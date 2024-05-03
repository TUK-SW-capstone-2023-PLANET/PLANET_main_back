package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.PloggingLiveDAO;
import com.capstone.planet.Model.DTO.TrashInfoDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class GetPloggingTrashInfoDAOBean {

    GetPloggingLiveDAOBean getPloggingLiveDAOBean;
    CheckNameBean checkNameBean;
    CheckNameScoreBean checkNameScoreBean;
    CheckNameImageUrlBean checkNameImageUrlBean;


    @Autowired
    public GetPloggingTrashInfoDAOBean(GetPloggingLiveDAOBean getPloggingLiveDAOBean, CheckNameBean checkNameBean, CheckNameScoreBean checkNameScoreBean, CheckNameImageUrlBean checkNameImageUrlBean) {
        this.getPloggingLiveDAOBean = getPloggingLiveDAOBean;
        this.checkNameBean = checkNameBean;
        this.checkNameScoreBean = checkNameScoreBean;
        this.checkNameImageUrlBean = checkNameImageUrlBean;
    }

    public List<Map<String, List<TrashInfoDTO>>> exec(Long ploggingId){

        // 시간순으로 정렬
        List<PloggingLiveDAO> ploggingLiveDAOList = getPloggingLiveDAOBean.exec(ploggingId, null);

        List<Map<String, List<TrashInfoDTO>>> trashInfoList = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();

        try {

            int totalScore = 0;

            for (PloggingLiveDAO ploggingLiveDAO : ploggingLiveDAOList) {
                List<Map<String, Integer>> mapList = objectMapper.readValue(ploggingLiveDAO.getTrash(), new TypeReference<List<Map<String, Integer>>>(){});

                List<TrashInfoDTO> trashInfoDTOS = new ArrayList<>();

                for (Map<String, Integer> map : mapList) {
                    for (Map.Entry<String, Integer> entry : map.entrySet()) {

                        String name = checkNameBean.exec(entry.getKey(), null);
                        String imageUrl = checkNameImageUrlBean.exec(entry.getKey());
                        Integer score = checkNameScoreBean.exec(entry.getKey()) * entry.getValue();
                        totalScore += score;

                        TrashInfoDTO trashInfoDTO = TrashInfoDTO.builder()
                                .name(name)
                                .imageUrl(imageUrl)
                                .address(ploggingLiveDAO.getAddress())
                                .count(entry.getValue())
                                .score(score)
                                .totalScore(totalScore)
                                .build();
                        trashInfoDTOS.add(trashInfoDTO);
                    }
                }

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("a h시 m분");
                String formattedUploadTime = ploggingLiveDAO.getUploadTime().format(formatter);

                trashInfoList.add(Map.of(formattedUploadTime, trashInfoDTOS));
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return trashInfoList;
    }
}
