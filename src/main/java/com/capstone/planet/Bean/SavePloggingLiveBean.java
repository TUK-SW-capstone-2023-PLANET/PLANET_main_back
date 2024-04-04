package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.CreatePloggingLiveDAOBean;
import com.capstone.planet.Bean.Small.CreateUniqueIdBean;
import com.capstone.planet.Bean.Small.SavePloggingLiveDAOBean;
import com.capstone.planet.Model.DAO.PloggingLiveDAO;
import com.capstone.planet.Model.DTO.RequestPloggingLiveSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.util.List;
import java.util.Map;

@Component
public class SavePloggingLiveBean {

    CreateUniqueIdBean createUniqueIdBean;
    CreatePloggingLiveDAOBean createPloggingLiveDAOBean;
    SavePloggingLiveDAOBean savePloggingLiveDAOBean;
    RestTemplate restTemplate;

    @Autowired
    public SavePloggingLiveBean(RestTemplateBuilder restTemplateBuilder, CreateUniqueIdBean createUniqueIdBean, CreatePloggingLiveDAOBean createPloggingLiveDAOBean, SavePloggingLiveDAOBean savePloggingLiveDAOBean) {
        this.restTemplate = restTemplateBuilder.build();
        this.createUniqueIdBean = createUniqueIdBean;
        this.createPloggingLiveDAOBean = createPloggingLiveDAOBean;
        this.savePloggingLiveDAOBean = savePloggingLiveDAOBean;
    }

    // 실시간 플로깅 쓰레기 사진 저장
    public List<Map<String, Integer>> exec(RequestPloggingLiveSaveDTO requestPloggingLiveSaveDTO) {

        // 고유 아이디 생성
        long ploggingLiveId = createUniqueIdBean.exec();

        PloggingLiveDAO ploggingLiveDAO = createPloggingLiveDAOBean.exec(ploggingLiveId, requestPloggingLiveSaveDTO);

        // 플로깅 라이브 저장
        savePloggingLiveDAOBean.exec(ploggingLiveDAO);

        /*// AI 로 부터 데이터 받아서 처리하는 로직이 필요함
        File imageFile = new File(requestPloggingLiveSaveDTO.getImageUrl()); // 실제 이미지 파일 경로로 변경해야 합니다*/

        /*// POST 요청 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        // POST 요청 파라미터 설정
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("imageUrl", requestPloggingLiveSaveDTO.getImageUrl());

        // POST 요청 엔티티 생성
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        // Flask API 엔드포인트 설정
        String apiUrl = "http://192.168.0.101:80/";

        // POST 요청 보내기
        ResponseEntity<byte[]> responseEntity = restTemplate.postForEntity(apiUrl, requestEntity, byte[].class);

        // Flask API에서 반환된 이미지 데이터 응답
        byte[] imageBytes = responseEntity.getBody();

        System.out.println("imageBytes = " + imageBytes.toString());*/

        // 더미 데이터 전송
        return List.of(Map.of("종이",1), Map.of("캔", 3), Map.of("플라스틱", 2), Map.of("유리", 1));
    }
}
