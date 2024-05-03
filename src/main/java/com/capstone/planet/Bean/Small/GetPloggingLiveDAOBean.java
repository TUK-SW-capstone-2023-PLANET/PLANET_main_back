package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.PloggingLiveDAO;
import com.capstone.planet.Repository.PloggingLiveRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetPloggingLiveDAOBean {

    PloggingLiveRepositoryJPA ploggingLiveRepositoryJPA;

    @Autowired
    public GetPloggingLiveDAOBean(PloggingLiveRepositoryJPA ploggingLiveRepositoryJPA) {
        this.ploggingLiveRepositoryJPA = ploggingLiveRepositoryJPA;
    }

    public List<PloggingLiveDAO> exec(Long ploggingId){
        return ploggingLiveRepositoryJPA.findByPloggingId(ploggingId);
    }

    public List<PloggingLiveDAO> exec(Long ploggingId, Long check){
        return ploggingLiveRepositoryJPA.findByPloggingIdOrderByUploadTimeAsc(ploggingId);
    }
}
