package com.capstone.planet.Service;

import com.capstone.planet.Bean.GetStatisticsMonthBean;
import com.capstone.planet.Bean.GetWeekStatisticsBean;
import com.capstone.planet.Model.DTO.ResponseStatisticsGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsService {

    GetWeekStatisticsBean getWeekStatisticsBean;
    GetStatisticsMonthBean getStatisticsMonthBean;

    @Autowired
    public StatisticsService(GetWeekStatisticsBean getWeekStatisticsBean, GetStatisticsMonthBean getStatisticsMonthBean) {
        this.getWeekStatisticsBean = getWeekStatisticsBean;
        this.getStatisticsMonthBean = getStatisticsMonthBean;
    }

    // 주간 통계 조회
    public ResponseStatisticsGetDTO getWeekStatistics(Long userId) {
        return getWeekStatisticsBean.exec(userId);
    }

    // 월간 통계 조회
    public ResponseStatisticsGetDTO getMonthStatistics(Long userId, String year, String month) {
        return getStatisticsMonthBean.exec(userId, year, month);
    }
}
