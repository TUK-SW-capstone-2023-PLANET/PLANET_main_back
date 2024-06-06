package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.MapSearchHistoryDAO;
import com.capstone.planet.Repository.MapSearchHistoryRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeleteMapSearchHisotyDAOBean {

    MapSearchHistoryRepositoryJPA mapSearchHistoryRepositoryJPA;

    @Autowired
    public DeleteMapSearchHisotyDAOBean(MapSearchHistoryRepositoryJPA mapSearchHistoryRepositoryJPA) {
        this.mapSearchHistoryRepositoryJPA = mapSearchHistoryRepositoryJPA;
    }

    public void exec(List<MapSearchHistoryDAO> mapSearchHistoryDAOS){
        mapSearchHistoryRepositoryJPA.deleteAll(mapSearchHistoryDAOS);
    }
}
