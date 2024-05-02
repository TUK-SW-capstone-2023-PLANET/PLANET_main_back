package com.capstone.planet.Bean.Small;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class GetAddressBean {

    public String exec(Double longitude, Double latitude) {

        // 좌표값
        String coords = longitude + "," + latitude;

        System.out.println("coords = " + coords);

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

            // 결과에서 주소 정보 가져오기
            JsonNode resultsNode = jsonNode.get("results").get("order");
            System.out.println("resultsNode = " + resultsNode);

            String area1 = "";
            String area2 = "";
            String area3 = "";

            for (JsonNode result : resultsNode) {
                if (result.get("name").asText().equals("legalcode")) {
                    JsonNode regionNode = result.get("region");
                    area1 = regionNode.get("area1").get("name").asText();
                    area2 = regionNode.get("area2").get("name").asText();
                    area3 = regionNode.get("area3").get("name").asText();
                }
            }

            System.out.println("area1 = " + area1);
            System.out.println("area3 = " + area2);
            System.out.println("area3 = " + area3);

            return area1 + " " + area2 + " " + area3;

        } catch (IOException | InterruptedException e) {
            // 예외 발생 시 처리
            e.printStackTrace();
        }

        return null;
    }
}
