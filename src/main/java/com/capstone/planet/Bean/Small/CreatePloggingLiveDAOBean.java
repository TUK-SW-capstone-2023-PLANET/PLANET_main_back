package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.PloggingLiveDAO;
import com.capstone.planet.Model.DTO.RequestPloggingLiveSaveDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CreatePloggingLiveDAOBean {

    CheckNameBean checkNameBean;

    @Autowired
    public CreatePloggingLiveDAOBean(CheckNameBean checkNameBean) {
        this.checkNameBean = checkNameBean;
    }

    // 실시간 플로깅 쓰레기 사진 DAO 생성
    public PloggingLiveDAO exec(Long ploggingLiveId, String address, RequestPloggingLiveSaveDTO requestPloggingLiveSaveDTO) {

        List<Map<String, Integer>> result = new ArrayList<>();

        for (Map<String, Integer> trashMap : requestPloggingLiveSaveDTO.getTrash()) {
            for (Map.Entry<String, Integer> entry : trashMap.entrySet()) {
                String category = checkNameBean.exec(entry.getKey());
                boolean categoryExists = false;
                for (Map<String, Integer> convertedMap : result) {
                    if (convertedMap.containsKey(category)) {
                        convertedMap.put(category, convertedMap.get(category) + entry.getValue());
                        categoryExists = true;
                        break;
                    }
                }
                if (!categoryExists) {
                    Map<String, Integer> convertedMap = new HashMap<>();
                    convertedMap.put(category, entry.getValue());
                    result.add(convertedMap);
                }
            }
        }

        ObjectMapper objectMapper = new ObjectMapper();
        String trash = null;
        try {
            trash = objectMapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


        PloggingLiveDAO ploggingLiveDAO = new PloggingLiveDAO();

        ploggingLiveDAO.setPloggingLiveId(ploggingLiveId);
        ploggingLiveDAO.setPloggingId(requestPloggingLiveSaveDTO.getPloggingId());
        ploggingLiveDAO.setUserId(requestPloggingLiveSaveDTO.getUserId());
        ploggingLiveDAO.setImageUrl(requestPloggingLiveSaveDTO.getImageUrl());
        ploggingLiveDAO.setLatitude(requestPloggingLiveSaveDTO.getLatitude());
        ploggingLiveDAO.setLongitude(requestPloggingLiveSaveDTO.getLongitude());
        ploggingLiveDAO.setTrash(trash);
        ploggingLiveDAO.setAddress(address);
        ploggingLiveDAO.setUploadTime(LocalDateTime.now().plusHours(9));

        return ploggingLiveDAO;
    }
}
