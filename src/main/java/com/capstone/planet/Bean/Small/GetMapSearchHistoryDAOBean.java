package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.MapSearchHistoryDAO;
import com.capstone.planet.Repository.MapSearchHistoryRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetMapSearchHistoryDAOBean {

    MapSearchHistoryRepositoryJPA mapSearchHistoryRepositoryJPA;

    @Autowired
    public GetMapSearchHistoryDAOBean(MapSearchHistoryRepositoryJPA mapSearchHistoryRepositoryJPA) {
        this.mapSearchHistoryRepositoryJPA = mapSearchHistoryRepositoryJPA;
    }

    // 지도 검색 히스토리 조회
    public List<MapSearchHistoryDAO> exec(Long userId){

        return mapSearchHistoryRepositoryJPA.findByUserIdOrderByUploadTimeDesc(userId);
    }
}
