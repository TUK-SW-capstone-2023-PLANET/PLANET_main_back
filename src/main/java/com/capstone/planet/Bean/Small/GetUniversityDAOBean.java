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

    public UniversityDAO exec(String name){
        return universityRepositoryJPA.findByName(name);
    }

    // 대학랭킹 3개
    public List<UniversityDAO> exec(){
        return universityRepositoryJPA.findTop3ByOrderByScoreDesc();
    }

    // 대학 전체 랭킹 조회
    public List<UniversityDAO> exec(String check1, String check2){
        return universityRepositoryJPA.findAllByOrderByScoreDesc();
    }
}
