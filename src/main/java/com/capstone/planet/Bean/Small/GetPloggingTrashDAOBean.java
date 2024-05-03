package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DTO.TrashDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class GetPloggingTrashDAOBean {

    CheckNameBean checkNameBean;
    CheckNameScoreBean checkNameScoreBean;

    @Autowired
    public GetPloggingTrashDAOBean(CheckNameBean checkNameBean, CheckNameScoreBean checkNameScoreBean) {
        this.checkNameBean = checkNameBean;
        this.checkNameScoreBean = checkNameScoreBean;
    }

    public List<TrashDTO> exec(String trash){

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            List<Map<String, Integer>> mapList = objectMapper.readValue(trash, new TypeReference<List<Map<String, Integer>>>(){});

            List<TrashDTO> trashDTOList = new ArrayList<>();
            for (Map<String, Integer> map : mapList) {
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    TrashDTO trashDTO = TrashDTO.builder()
                            .name(checkNameBean.exec(entry.getKey(), "trash"))
                            .count(entry.getValue())
                            .score(checkNameScoreBean.exec(entry.getKey()) * entry.getValue())
                            .build();
                    trashDTOList.add(trashDTO);
                }
            }
            return trashDTOList;

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
