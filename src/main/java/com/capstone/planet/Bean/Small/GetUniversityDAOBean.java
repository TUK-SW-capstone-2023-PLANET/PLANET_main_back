package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.UniversityDAO;
import com.capstone.planet.Repository.UniversityRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetUniversityDAOBean {

    UniversityRepositoryJPA universityRepositoryJPA;

    @Autowired
    public GetUniversityDAOBean(UniversityRepositoryJPA universityRepositoryJPA) {
        this.universityRepositoryJPA = universityRepositoryJPA;
    }

    public List<UniversityDAO> exec(){
        return universityRepositoryJPA.findTop3ByOrderByScoreDesc();
    }
}
