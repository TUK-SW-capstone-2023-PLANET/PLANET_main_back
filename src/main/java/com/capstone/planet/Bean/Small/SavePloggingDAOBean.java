package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.PloggingDAO;
import com.capstone.planet.Repository.PloggingRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SavePloggingDAOBean {

    PloggingRepositoryJPA ploggingRepositoryJPA;

    @Autowired
    public SavePloggingDAOBean(PloggingRepositoryJPA ploggingRepositoryJPA) {
        this.ploggingRepositoryJPA = ploggingRepositoryJPA;
    }

    // 플로깅 정보 저장
    public void exec(PloggingDAO ploggingDAO){
        ploggingRepositoryJPA.save(ploggingDAO);
    }
}
