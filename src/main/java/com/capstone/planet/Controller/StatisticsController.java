package com.capstone.planet.Controller;

import com.capstone.planet.Model.DTO.ResponseStatisticsGetDTO;
import com.capstone.planet.Service.StatisticsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Statistics", description = "통계 관련 API")
@RestController
@CrossOrigin("*")
public class StatisticsController {

    StatisticsService statisticsService;

    @Autowired
    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    // 주간 통계 조회
    @Operation(summary = "주간 통계 조회", description = "주간 통계 조회")
    @GetMapping("/statistics/week/user/{userId}")
    public ResponseStatisticsGetDTO getWeekStatistics(@PathVariable Long userId) {
        return statisticsService.getWeekStatistics(userId);
    }

    // 월간 통계 조회
    @Operation(summary = "월간 통계 조회", description = "월간 통계 조회")
    @GetMapping("/statistics/year/{year}/month/{month}/user/{userId}")
    public ResponseStatisticsGetDTO getMonthStatistics(@PathVariable Long userId, @PathVariable String year, @PathVariable String month) {
        return statisticsService.getMonthStatistics(userId, year, month);
    }
}
