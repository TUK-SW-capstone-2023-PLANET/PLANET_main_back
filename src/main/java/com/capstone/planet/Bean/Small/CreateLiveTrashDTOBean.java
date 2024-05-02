package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.PloggingLiveDAO;
import com.capstone.planet.Model.DTO.LiveTrashDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CreateLiveTrashDTOBean {

    GetPloggingLiveDAOBean getPloggingLiveDAOBean;
    CheckNameImageUrlBean checkNameImageUrlBean;
    CheckNameBean checkNameBean;
    CheckNameScoreBean checkNameScoreBean;

    @Autowired
    public CreateLiveTrashDTOBean(GetPloggingLiveDAOBean getPloggingLiveDAOBean, CheckNameImageUrlBean checkNameImageUrlBean, CheckNameBean checkNameBean, CheckNameScoreBean checkNameScoreBean) {
        this.getPloggingLiveDAOBean = getPloggingLiveDAOBean;
        this.checkNameImageUrlBean = checkNameImageUrlBean;
        this.checkNameBean = checkNameBean;
        this.checkNameScoreBean = checkNameScoreBean;
    }

    public List<LiveTrashDTO> exec(Long ploggingId) {

        // getPloggingLiveDAOBean.exec(ploggingId)로부터 PloggingLiveDAO 리스트를 가져온다고 가정합니다.
        List<PloggingLiveDAO> ploggingLiveDAOList = getPloggingLiveDAOBean.exec(ploggingId);

        // 모든 키-값 쌍을 저장할 Map<String, Integer>를 생성합니다.
        Map<String, Integer> mergedMap = new HashMap<>();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // 각 PloggingLiveDAO 객체의 List<Map<String, Integer>>에 대해 반복합니다.
            for (PloggingLiveDAO ploggingLiveDAO : ploggingLiveDAOList) {
                List<Map<String, Integer>> trash = objectMapper.readValue(ploggingLiveDAO.getTrash(), List.class);

                // 각 맵에 대해 반복하며 키-값을 mergedMap에 더합니다.
                for (Map<String, Integer> map : trash) {
                    for (Map.Entry<String, Integer> entry : map.entrySet()) {
                        String key = entry.getKey();
                        int value = entry.getValue();
                        mergedMap.put(key, mergedMap.getOrDefault(key, 0) + value);
                    }
                }
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        // Map을 List<Map<String, Integer>> 형태로 변환합니다.
        List<Map<String, Integer>> resultList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : mergedMap.entrySet()) {
            Map<String, Integer> map = new HashMap<>();
            map.put(entry.getKey(), entry.getValue());
            resultList.add(map);
        }


        // 결과를 출력하거나 다른 곳에 사용할 수 있습니다.
        System.out.println(resultList);

        List<LiveTrashDTO> liveTrashDTOList = new ArrayList<>();

        // LiveTrashDTO로 변환하여 결과 리스트에 추가
        for (Map<String, Integer> map : resultList) {
            String key = map.keySet().iterator().next();
            Integer count = map.get(key);

            // 이미지 URL과 점수는 어디서 가져오는지에 따라 적절히 수정해야 합니다.
            // 예시로 각각 "imageUrl"과 "score"로 고정값을 넣었습니다.
            LiveTrashDTO liveTrashDTO = new LiveTrashDTO();
            liveTrashDTO.setImageUrl(checkNameImageUrlBean.exec(key));
            liveTrashDTO.setName(checkNameBean.exec(key, null));
            liveTrashDTO.setCount(count);
            liveTrashDTO.setScore(checkNameScoreBean.exec(key)*count);

            liveTrashDTOList.add(liveTrashDTO);
        }

        return liveTrashDTOList;
    }
}
