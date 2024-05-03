package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.PloggingDAO;
import com.capstone.planet.Model.DTO.RequestPloggingSaveDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Component
public class CreatePloggingDAOBean {

    // 플로깅 DAO 생성
    public PloggingDAO exec(String imageUrl, RequestPloggingSaveDTO requestPloggingSaveDTO){

        List<Map<String, Integer>> trash = requestPloggingSaveDTO.getTrash();
        int trashCount = 0;
        for(Map<String, Integer> map : trash){
            for(String key : map.keySet()){
                trashCount += map.get(key);
            }
        }

        PloggingDAO ploggingDAO = new PloggingDAO();

        ploggingDAO.setPloggingId(requestPloggingSaveDTO.getPloggingId());
        ploggingDAO.setUserId(requestPloggingSaveDTO.getUserId());
        ploggingDAO.setImageUrl(imageUrl);
        ploggingDAO.setDistance(requestPloggingSaveDTO.getDistance());
        ploggingDAO.setKcal(requestPloggingSaveDTO.getKcal());
        ploggingDAO.setSpeed(requestPloggingSaveDTO.getSpeed());
        ploggingDAO.setScore(requestPloggingSaveDTO.getScore());
        ploggingDAO.setTrashCount(trashCount);
        ploggingDAO.setPloggingTime(requestPloggingSaveDTO.getPloggingTime());
        ploggingDAO.setUploadTime(LocalDateTime.now());

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ploggingDAO.setLocation(objectMapper.writeValueAsString(requestPloggingSaveDTO.getLocation()));
            ploggingDAO.setTrash(objectMapper.writeValueAsString(requestPloggingSaveDTO.getTrash()));
        } catch (Exception e){
            e.printStackTrace();
        }

        return ploggingDAO;
    }
}
