package com.capstone.planet.Bean;

import com.capstone.planet.Model.DTO.LocationDTO;
import com.capstone.planet.Model.DTO.ResponseSearchMapGetDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class GetSearchMapBean {

    Environment env;

    @Autowired
    public GetSearchMapBean(Environment env) {
        this.env = env;
    }

    // 지도 위치 검색
    public ResponseSearchMapGetDTO exec(String search) {

        search = search.replace(" ", "+");

        // API 호출을 위한 URL
        String apiUrl = "https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query=" + search;

        // HttpClient 객체 생성
        HttpClient httpClient = HttpClient.newHttpClient();

        // HTTP 요청 객체 생성
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("X-NCP-APIGW-API-KEY-ID", env.getProperty("naver.X-NCP-APIGW-API-KEY-ID"))
                .header("X-NCP-APIGW-API-KEY", env.getProperty("naver.X-NCP-APIGW-API-KEY"))
                .GET()
                .build();


        try {
            // HTTP 요청 보내기
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            // JSON 매퍼 생성
            ObjectMapper jsonMapper = new ObjectMapper();

            // XML 파싱하여 JsonNode로 변환
            JsonNode jsonNode = jsonMapper.readTree(httpResponse.body());

            String date;
            date = LocalDateTime.now().plusHours(9).format(DateTimeFormatter.ofPattern("MM.dd"));

            String status = jsonNode.get("status").toString().replace("\"", "");

            if (jsonNode.get("addresses").isEmpty() || !status.equals("OK")) {
                LocationDTO locationDTO = new LocationDTO();
                locationDTO.setLatitude(0.0);
                locationDTO.setLongitude(0.0);

                ResponseSearchMapGetDTO responseSearchMapGetDTO = new ResponseSearchMapGetDTO();
                responseSearchMapGetDTO.setText("잘못 입력함.");
                responseSearchMapGetDTO.setDate(date);
                responseSearchMapGetDTO.setLocation(locationDTO);
                responseSearchMapGetDTO.setAddressCheck(false);

                return responseSearchMapGetDTO;
            }

            Double latitude = Double.parseDouble(jsonNode.get("addresses").get(0).get("y").toString().replace("\"", ""));
            Double longitude = Double.parseDouble(jsonNode.get("addresses").get(0).get("x").toString().replace("\"", ""));

            LocationDTO locationDTO = new LocationDTO();
            locationDTO.setLatitude(latitude);
            locationDTO.setLongitude(longitude);

            ResponseSearchMapGetDTO responseSearchMapGetDTO = new ResponseSearchMapGetDTO();
            search = search.replace("+", " ");
            responseSearchMapGetDTO.setText(search);
            responseSearchMapGetDTO.setDate(date);
            responseSearchMapGetDTO.setLocation(locationDTO);
            responseSearchMapGetDTO.setAddressCheck(true);

            return responseSearchMapGetDTO;

        } catch (IOException | InterruptedException e) {
            // 예외 발생 시 처리
            e.printStackTrace();
        }

        return null;
    }

}
