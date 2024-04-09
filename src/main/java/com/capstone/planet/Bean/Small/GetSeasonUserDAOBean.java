package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.SeasonDAO;
import com.capstone.planet.Repository.SeasonRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetSeasonUserDAOBean {

    SeasonRepositoryJPA seasonRepositoryJPA;

    @Autowired
    public GetSeasonUserDAOBean(SeasonRepositoryJPA seasonRepositoryJPA) {
        this.seasonRepositoryJPA = seasonRepositoryJPA;
    }

    public SeasonDAO exec(Long userId){
        return seasonRepositoryJPA.findByUserId(userId);
    }

    // 시즌에 소속된 유저 점수 순으로 3개 가져오기
    public List<SeasonDAO> exec(String check){
        return seasonRepositoryJPA.findTop3ByOrderByScoreDesc();
    }

    // 시즌에 소속된 유저 점수 순으로 전부 가져오기
    public List<SeasonDAO> exec(){
        return seasonRepositoryJPA.findAllByOrderByScoreDesc();
    }

    // 시즌에 소속된 유저 점수 순으로 전부 가져오기
    public Page<SeasonDAO> exec(Pageable pageable){
        return seasonRepositoryJPA.findAll(pageable);
    }
}
