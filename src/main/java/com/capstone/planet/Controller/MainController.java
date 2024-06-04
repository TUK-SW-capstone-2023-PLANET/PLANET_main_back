package com.capstone.planet.Controller;

import com.capstone.planet.Bean.Small.CreateMultipartFileBean;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.univcert.api.UnivCert;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
import java.util.Map;

@Tag(name = "Main", description = "서버 상태 확인 및 테스트용 API")
@RestController
@CrossOrigin("*")
public class MainController {

    @Autowired
    CreateMultipartFileBean createMultipartFileBean;


    //@Operation(summary = "상태 확인", description = "서버 생존 확인 API")
    /*@GetMapping("/")
    public String health() {

        String address= "경기도+시흥시+정왕동";

        System.out.println("address = " + address);

        // API 호출을 위한 URL
        String apiUrl = "https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query=" + address;

        // HttpClient 객체 생성
        HttpClient httpClient = HttpClient.newHttpClient();

        // HTTP 요청 객체 생성
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("X-NCP-APIGW-API-KEY-ID", "d62cogf955")
                .header("X-NCP-APIGW-API-KEY", "PD9WvJTFLDShaTWdAN0JiYJPfusVsO3tRv4SMDbv")
                .GET()
                .build();

        System.out.println("apiUrl = " + apiUrl);

        try {
            // HTTP 요청 보내기
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            // XML 매퍼 생성
            XmlMapper xmlMapper = new XmlMapper();
            // JSON 매퍼 생성
            ObjectMapper jsonMapper = new ObjectMapper();

            // XML 파싱하여 JsonNode로 변환
            JsonNode jsonNode = jsonMapper.readTree(httpResponse.body());

            System.out.println("jsonNode = " + jsonNode.get("status"));
            System.out.println("jsonNode.get(\"addresses\").get(\"x\") = " + jsonNode.get("addresses").get(0).get("x"));
            System.out.println("jsonNode.get(\"addresses\").get(\"y\") = " + jsonNode.get("addresses").get(0).get("y"));

            return jsonNode.toString();

        } catch (IOException | InterruptedException e) {
            // 예외 발생 시 처리
            e.printStackTrace();
        }

        return null;
    }*/
}