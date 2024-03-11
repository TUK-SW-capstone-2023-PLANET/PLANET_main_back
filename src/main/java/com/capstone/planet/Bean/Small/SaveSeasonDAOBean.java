package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.SeasonDAO;
import com.capstone.planet.Repository.SeasonRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveSeasonDAOBean {

    SeasonRepositoryJPA seasonRepositoryJPA;

    @Autowired
    public SaveSeasonDAOBean(SeasonRepositoryJPA seasonRepositoryJPA) {
        this.seasonRepositoryJPA = seasonRepositoryJPA;
    }

    public void exec(SeasonDAO seasonDAO){
        seasonRepositoryJPA.save(seasonDAO);
    }
}
