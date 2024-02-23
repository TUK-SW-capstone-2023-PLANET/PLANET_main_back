package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.PloggingDAO;
import com.capstone.planet.Repository.PloggingRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetPloggingDAOBean {

    PloggingRepositoryJPA ploggingRepositoryJPA;

    @Autowired
    public GetPloggingDAOBean(PloggingRepositoryJPA ploggingRepositoryJPA) {
        this.ploggingRepositoryJPA = ploggingRepositoryJPA;
    }

    // 플로깅 객체 가져오기
    public PloggingDAO exec(Long ploggingId){
        return ploggingRepositoryJPA.findById(ploggingId).orElse(null);
    }
}
