package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.PloggingDAO;
import com.capstone.planet.Model.DTO.RequestPloggingSaveDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class CreatePloggingDAOBean {

    CheckNameBean checkNameBean;

    @Autowired
    public CreatePloggingDAOBean(CheckNameBean checkNameBean) {
        this.checkNameBean = checkNameBean;
    }

    // 플로깅 DAO 생성
    public PloggingDAO exec(String address, String imageUrl, RequestPloggingSaveDTO requestPloggingSaveDTO){

        List<Map<String, Integer>> newTrash = new ArrayList<>();
        List<Map<String, Integer>> trash = requestPloggingSaveDTO.getTrash();
        int trashCount = 0;
        for(Map<String, Integer> map : trash){
            for(String key : map.keySet()){
                trashCount += map.get(key);

                newTrash.add(Map.of(checkNameBean.exec(key, null, null), map.get(key)));
            }
        }


        LocalDateTime now = LocalDateTime.now().plusHours(9);

        // 시간에서 년 월 일 가져오기
        String month = String.valueOf(now.getYear()) + String.format("%02d", now.getMonthValue());
        Integer day = now.getDayOfMonth();


        PloggingDAO ploggingDAO = new PloggingDAO();

        ploggingDAO.setPloggingId(requestPloggingSaveDTO.getPloggingId());
        ploggingDAO.setUserId(requestPloggingSaveDTO.getUserId());
        ploggingDAO.setImageUrl(imageUrl);
        ploggingDAO.setDistance(requestPloggingSaveDTO.getDistance());
        ploggingDAO.setKcal(requestPloggingSaveDTO.getKcal());
        ploggingDAO.setPace(requestPloggingSaveDTO.getPace());
        ploggingDAO.setScore(requestPloggingSaveDTO.getScore());
        ploggingDAO.setTrashCount(trashCount);
        ploggingDAO.setPloggingTime(requestPloggingSaveDTO.getPloggingTime());
        ploggingDAO.setMonth(month);
        ploggingDAO.setDay(day);
        ploggingDAO.setAddress(address);
        ploggingDAO.setUploadTime(now);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ploggingDAO.setLocation(objectMapper.writeValueAsString(requestPloggingSaveDTO.getLocation()));
            ploggingDAO.setTrash(objectMapper.writeValueAsString(newTrash));
        } catch (Exception e){
            e.printStackTrace();
        }

        return ploggingDAO;
    }
}
