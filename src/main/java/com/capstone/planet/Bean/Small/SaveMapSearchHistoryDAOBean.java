package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.MapSearchHistoryDAO;
import com.capstone.planet.Repository.MapSearchHistoryRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveMapSearchHistoryDAOBean {

    MapSearchHistoryRepositoryJPA mapSearchHistoryRepositoryJPA;

    @Autowired
    public SaveMapSearchHistoryDAOBean(MapSearchHistoryRepositoryJPA mapSearchHistoryRepositoryJPA) {
        this.mapSearchHistoryRepositoryJPA = mapSearchHistoryRepositoryJPA;
    }

    // 지도 검색 저장
    public void exec(MapSearchHistoryDAO mapSearchHistoryDAO){
        mapSearchHistoryRepositoryJPA.save(mapSearchHistoryDAO);
    }

}
