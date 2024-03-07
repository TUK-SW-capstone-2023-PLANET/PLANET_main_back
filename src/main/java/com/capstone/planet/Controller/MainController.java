package com.capstone.planet.Controller;

import com.capstone.planet.Bean.Small.CreateMultipartFileBean;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Tag(name = "Main", description = "서버 상태 확인 및 테스트용 API")
@RestController
@CrossOrigin("*")
public class MainController {

    @Autowired
    CreateMultipartFileBean createMultipartFileBean;

    @GetMapping("/")
    public void getMapImage() {
        String URL_STATICMAP = "https://naveropenapi.apigw.ntruss.com/map-static/v2/raster?";

        try {
            String url = URL_STATICMAP;
            url += "center=126.97838810000002,37.56661020000001";
            url += "&level=16&w=500&h=500";

            URL u = new URL(url);
            HttpURLConnection con = (HttpURLConnection) u.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", "d62cogf955");
            con.setRequestProperty("X-NCP-APIGW-API-KEY", "PD9WvJTFLDShaTWdAN0JiYJPfusVsO3tRv4SMDbv");

            int responseCode = con.getResponseCode();

            // 정상호출인 경우.
            if (responseCode == 200) {
                InputStream is = con.getInputStream();
                BufferedImage image = ImageIO.read(is);
                is.close();

            } else {    // 에러 발생
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
                throw new IOException("Error response from server: " + response.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //@Operation(summary = "상태 확인", description = "서버 생존 확인 API")
    //@GetMapping("/")
    public JsonNode health() {

        // 좌표값
        String coords = "126.97838810000002,37.56661020000001";
        // API 호출을 위한 URL
        String apiUrl = "https://naveropenapi.apigw.ntruss.com/map-reversegeocode/v2/gc?coords=" + coords;

        // HttpClient 객체 생성
        HttpClient httpClient = HttpClient.newHttpClient();

        // HTTP 요청 객체 생성
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("X-NCP-APIGW-API-KEY-ID", "d62cogf955")
                .header("X-NCP-APIGW-API-KEY", "PD9WvJTFLDShaTWdAN0JiYJPfusVsO3tRv4SMDbv")
                .GET()
                .build();

        try {
            // HTTP 요청 보내기
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            // XML 매퍼 생성
            XmlMapper xmlMapper = new XmlMapper();
            // JSON 매퍼 생성
            ObjectMapper jsonMapper = new ObjectMapper();

            // XML 파싱하여 JsonNode로 변환
            JsonNode jsonNode = xmlMapper.readTree(httpResponse.body());

            // JsonNode를 JSON 문자열로 변환하여 반환
            System.out.println("Response: " + jsonMapper.writeValueAsString(jsonNode));

            return jsonNode;
        } catch (IOException | InterruptedException e) {
            // 예외 발생 시 처리
            e.printStackTrace();
        }

        return null;
    }

    // XML을 JSON으로 변환하는 메소드
    private static String convertXmlToJson(String xml) throws IOException {
        // XML 매퍼 생성
        XmlMapper xmlMapper = new XmlMapper();
        // JSON 매퍼 생성
        ObjectMapper jsonMapper = new ObjectMapper();

        // XML 파싱하여 JsonNode로 변환
        JsonNode jsonNode = xmlMapper.readTree(xml);

        // JsonNode를 JSON 문자열로 변환하여 반환
        return jsonMapper.writeValueAsString(jsonNode);
    }
}