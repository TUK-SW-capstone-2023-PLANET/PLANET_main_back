package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.PloggingDAO;
import com.capstone.planet.Model.DTO.RequestPloggingSaveDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CreatePloggingDAOBean {

    // 플로깅 DAO 생성
    public PloggingDAO exec(RequestPloggingSaveDTO requestPloggingSaveDTO){

        PloggingDAO ploggingDAO = new PloggingDAO();

        ploggingDAO.setPloggingId(requestPloggingSaveDTO.getPloggingId());
        ploggingDAO.setUserId(requestPloggingSaveDTO.getUserId());
        ploggingDAO.setImageUrl(requestPloggingSaveDTO.getImageUrl());
        ploggingDAO.setDistance(requestPloggingSaveDTO.getDistance());
        ploggingDAO.setKcal(requestPloggingSaveDTO.getKcal());
        ploggingDAO.setSpeed(requestPloggingSaveDTO.getSpeed());
        ploggingDAO.setScore(requestPloggingSaveDTO.getScore());
        ploggingDAO.setPloggingTime(requestPloggingSaveDTO.getPloggingTime());
        ploggingDAO.setUploadTime(LocalDateTime.now());

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ploggingDAO.setLocation(objectMapper.writeValueAsString(requestPloggingSaveDTO.getLocation()));
            ploggingDAO.setTrashCount(objectMapper.writeValueAsString(requestPloggingSaveDTO.getTrashCount()));
        } catch (Exception e){
            e.printStackTrace();
        }

        return ploggingDAO;
    }
}
