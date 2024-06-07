package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.GetMapSearchHistoryDAOBean;
import com.capstone.planet.Bean.Small.GetPostSearchHistoryDAOBean;
import com.capstone.planet.Model.DAO.MapSearchHistoryDAO;
import com.capstone.planet.Model.DAO.PostSearchHistoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class GetMapHistoryBean {

    GetMapSearchHistoryDAOBean getMapSearchHistoryDAOBean;

    @Autowired
    public GetMapHistoryBean(GetMapSearchHistoryDAOBean getMapSearchHistoryDAOBean) {
        this.getMapSearchHistoryDAOBean = getMapSearchHistoryDAOBean;
    }

    // 지도 히스토리 조회
    public List<Map<String, String>> exec(Long userId) {
        List<MapSearchHistoryDAO> mapSearchHistoryDAOS = getMapSearchHistoryDAOBean.exec(userId);

        if (mapSearchHistoryDAOS == null) {
            return List.of();
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM.dd");
            return mapSearchHistoryDAOS.stream()
                    .map(dao -> Map.of(
                            "search", dao.getSearch(),
                            "date", dao.getUploadTime().format(formatter)
                    ))
                    .collect(Collectors.toList());
        }
    }
}
