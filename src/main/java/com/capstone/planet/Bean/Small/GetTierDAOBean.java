package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.TierDAO;
import com.capstone.planet.Repository.TierRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetTierDAOBean {

    TierRepositoryJPA tierRepositoryJPA;

    @Autowired
    public GetTierDAOBean(TierRepositoryJPA tierRepositoryJPA) {
        this.tierRepositoryJPA = tierRepositoryJPA;
    }

    public List<TierDAO> exec(){
        return tierRepositoryJPA.findALLByOrderByTierIdAsc();
    }
}
