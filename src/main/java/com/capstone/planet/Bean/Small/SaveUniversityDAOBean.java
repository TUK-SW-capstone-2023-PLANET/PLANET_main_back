package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.UniversityDAO;
import com.capstone.planet.Repository.UniversityRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveUniversityDAOBean {

    UniversityRepositoryJPA universityRepositoryJPA;

    @Autowired
    public SaveUniversityDAOBean(UniversityRepositoryJPA universityRepositoryJPA) {
        this.universityRepositoryJPA = universityRepositoryJPA;
    }

    public void exec(UniversityDAO universityDAO){
        universityRepositoryJPA.save(universityDAO);
    }
}
