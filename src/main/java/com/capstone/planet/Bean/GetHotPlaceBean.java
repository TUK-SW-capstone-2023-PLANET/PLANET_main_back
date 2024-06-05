package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.GetPloggingDAOBean;
import com.capstone.planet.Model.DAO.PloggingDAO;
import com.capstone.planet.Model.DTO.LocationDTO;
import com.capstone.planet.Model.DTO.ResponseHotPlaceGetDTO;
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
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetHotPlaceBean {

    GetPloggingDAOBean getPloggingDAOBean;
    ObjectMapper objectMapper;
    Environment env;

    @Autowired
    public GetHotPlaceBean(GetPloggingDAOBean getPloggingDAOBean, ObjectMapper objectMapper, Environment env) {
        this.getPloggingDAOBean = getPloggingDAOBean;
        this.objectMapper = objectMapper;
        this.env = env;
    }

    // 핫플레이스 조회
    public List<ResponseHotPlaceGetDTO> exec(){

        List<PloggingDAO> ploggingDAOS = getPloggingDAOBean.exec();

        return ploggingDAOS.stream()
                .collect(Collectors.groupingBy(PloggingDAO::getAddress, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(10)
                .map(entry -> {
                    String address = entry.getKey();
                    long count = entry.getValue();
                    LocationDTO location = exec(address);
                    return ResponseHotPlaceGetDTO.builder()
                            .address(address)
                            .ploggingCount((int) count)
                            .location(location)
                            .build();
                })
                .collect(Collectors.toList());
    }

    public LocationDTO exec(String search) {

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

            Double latitude = Double.parseDouble(jsonNode.get("addresses").get(0).get("y").toString().replace("\"", ""));
            Double longitude = Double.parseDouble(jsonNode.get("addresses").get(0).get("x").toString().replace("\"", ""));

            LocationDTO locationDTO = new LocationDTO();
            locationDTO.setLatitude(latitude);
            locationDTO.setLongitude(longitude);


            return locationDTO;

        } catch (IOException | InterruptedException e) {
            // 예외 발생 시 처리
            e.printStackTrace();
        }

        return null;
    }
}
