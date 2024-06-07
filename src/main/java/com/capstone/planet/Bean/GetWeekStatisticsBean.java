package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.GetPloggingDAOBean;
import com.capstone.planet.Model.DAO.PloggingDAO;
import com.capstone.planet.Model.DTO.DataList;
import com.capstone.planet.Model.DTO.ResponseStatisticsGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class GetWeekStatisticsBean {

    GetPloggingDAOBean getPloggingDAOBean;

    @Autowired
    public GetWeekStatisticsBean(GetPloggingDAOBean getPloggingDAOBean) {
        this.getPloggingDAOBean = getPloggingDAOBean;
    }

    // 주간 통계 조회
    public ResponseStatisticsGetDTO exec(Long userId) {
        List<PloggingDAO> ploggingDAOS = getPloggingDAOBean.exec(userId, 0L);

        LocalDate today = LocalDate.now();
        LocalDate oneWeekAgo = today.minusDays(6); // 오늘 포함 7일치 데이터를 위해 6일을 뺍니다.

        // 필터링: 오늘 기준으로 이전 7일치 데이터만 추출
        List<PloggingDAO> lastWeekPloggingDAOS = ploggingDAOS.stream()
                .filter(dao -> {
                    LocalDate uploadDate = dao.getUploadTime().toLocalDate();
                    return !uploadDate.isBefore(oneWeekAgo) && !uploadDate.isAfter(today);
                })
                .toList();

        // 날짜별로 그룹화 및 점수 합계 계산
        Map<LocalDate, Integer> dailyScores = lastWeekPloggingDAOS.stream()
                .collect(Collectors.groupingBy(
                        dao -> dao.getUploadTime().toLocalDate(),
                        Collectors.summingInt(PloggingDAO::getScore)
                ));

        // 모든 날짜 리스트 생성
        List<LocalDate> allDates = IntStream.rangeClosed(0, 6)
                .mapToObj(oneWeekAgo::plusDays)
                .toList();

        // 요일 형식으로 변환하기 위한 포맷터
        DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("E");

        // DataList 변환
        List<DataList> dataList = allDates.stream()
                .map(date -> DataList.builder()
                        .day(date.format(dayFormatter))
                        .score(dailyScores.getOrDefault(date, 0))
                        .build())
                .collect(Collectors.toList());

        // 평균 계산
        int totalScore = dailyScores.values().stream().mapToInt(Integer::intValue).sum();
        int averageScore = !dailyScores.isEmpty() ? totalScore / dailyScores.size() : 0;

        // ResponseStatisticsGetDTO 생성
        return ResponseStatisticsGetDTO.builder()
                .average(averageScore)
                .dataList(dataList)
                .build();
    }
}
