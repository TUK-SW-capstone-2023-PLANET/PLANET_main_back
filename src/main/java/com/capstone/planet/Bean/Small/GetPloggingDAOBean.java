package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.PloggingDAO;
import com.capstone.planet.Repository.PloggingRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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

    // 플로깅 개게 userId와 month 일치하는 객체 day 기준으로 Asc 정렬 후 가져오기
    public List<PloggingDAO> exec(Long userId, String month){
        return ploggingRepositoryJPA.findByUserIdAndMonthOrderByDayAsc(userId, month);
    }

    public List<PloggingDAO> exec(Long userId, Long check){
        return ploggingRepositoryJPA.findByUserIdOrderByMonthDesc(userId);
    }

    // 핫 플레이스 조회
    public List<PloggingDAO> exec(){
        return ploggingRepositoryJPA.findAll();
    }
}
