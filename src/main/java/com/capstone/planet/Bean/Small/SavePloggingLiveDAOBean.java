package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.PloggingLiveDAO;
import com.capstone.planet.Repository.PloggingLiveRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SavePloggingLiveDAOBean {

    PloggingLiveRepositoryJPA ploggingLiveRepositoryJPA;

    @Autowired
    public SavePloggingLiveDAOBean(PloggingLiveRepositoryJPA ploggingLiveRepositoryJPA) {
        this.ploggingLiveRepositoryJPA = ploggingLiveRepositoryJPA;
    }

    // 실시간 플로깅 쓰레기 사진 저장
    public void exec(PloggingLiveDAO ploggingLiveDAO) {
        // 플로깅 라이브 저장
        ploggingLiveRepositoryJPA.save(ploggingLiveDAO);
    }
}
