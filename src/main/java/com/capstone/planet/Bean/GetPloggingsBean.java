package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.CreatePloggingDTOsBean;
import com.capstone.planet.Bean.Small.GetPloggingDAOBean;
import com.capstone.planet.Model.DAO.PloggingDAO;
import com.capstone.planet.Model.DTO.ResponsePloggingGetsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GetPloggingsBean {

    GetPloggingDAOBean getPloggingDAOBean;
    CreatePloggingDTOsBean createPloggingDTOsBean;

    @Autowired
    public GetPloggingsBean(GetPloggingDAOBean getPloggingDAOBean, CreatePloggingDTOsBean createPloggingDTOsBean) {
        this.getPloggingDAOBean = getPloggingDAOBean;
        this.createPloggingDTOsBean = createPloggingDTOsBean;
    }

    // 플로깅 월별로 전체 조회
    public List<Map<Integer, List<ResponsePloggingGetsDTO>>> exec(Long userId, String year, String month){

        // 년 월 합치기
        if (month.length() == 1)
            month = "0" + month;

        month = year + month;

        // 유저 Id랑 년월 일치하는 객체 day Asc 순으로 정렬 후 가져오기
        List<PloggingDAO> ploggingDAOS = getPloggingDAOBean.exec(userId, month);

        List<Map<Integer, List<ResponsePloggingGetsDTO>>> result = new ArrayList<>();


        // day를 key 값으로 하고 List<ResponsePloggingGetsDTO>를 value로 하는 리스트 반환
        for (PloggingDAO ploggingDAO : ploggingDAOS) {

            Integer day = ploggingDAO.getDay();

            boolean check = false;
            for (Map<Integer, List<ResponsePloggingGetsDTO>> map : result) {
                if (map.containsKey(day)) {
                    check = true;
                    List<ResponsePloggingGetsDTO> responsePloggingGetsDTOS = map.get(day);
                    responsePloggingGetsDTOS.add(createPloggingDTOsBean.exec(ploggingDAO));
                    break;
                }
            }

            // 만약 result의 Map 에 day가 없다면 새로운 Map을 생성하여 추가
            if (!check) {
                Map<Integer, List<ResponsePloggingGetsDTO>> map = new HashMap<>();
                List<ResponsePloggingGetsDTO> list = new ArrayList<>();
                ResponsePloggingGetsDTO responsePloggingGetsDTO = createPloggingDTOsBean.exec(ploggingDAO);
                list.add(responsePloggingGetsDTO);
                map.put(day, list);
                result.add(map);
            }
        }

        return result;
    }
}
