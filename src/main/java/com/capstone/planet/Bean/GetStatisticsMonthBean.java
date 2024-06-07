package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.GetPloggingDAOBean;
import com.capstone.planet.Model.DAO.PloggingDAO;
import com.capstone.planet.Model.DTO.DataList;
import com.capstone.planet.Model.DTO.ResponseStatisticsGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class GetStatisticsMonthBean {

    GetPloggingDAOBean getPloggingDAOBean;

    @Autowired
    public GetStatisticsMonthBean(GetPloggingDAOBean getPloggingDAOBean) {
        this.getPloggingDAOBean = getPloggingDAOBean;
    }

    // 월별 통계 조회
    public ResponseStatisticsGetDTO exec(Long userId, String year, String month) {
        // 원하는 년도와 월로 LocalDate를 만듭니다.
        YearMonth yearMonth = YearMonth.of(Integer.parseInt(year), Integer.parseInt(month));

        // 해당 월의 시작 날짜와 끝 날짜를 구합니다.
        LocalDate startDate = yearMonth.atDay(1);
        LocalDate endDate = yearMonth.atEndOfMonth();

        // 해당 월에 있는 모든 날짜를 리스트에 담습니다.
        List<LocalDate> allDates = new ArrayList<>();
        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            allDates.add(date);
        }

        // 년 월 합치기
        if (month.length() == 1)
            month = "0" + month;

        month = year + month;

        List<PloggingDAO> ploggingDAOS = getPloggingDAOBean.exec(userId, month);

        // 날짜별로 그룹화 및 점수 합계 계산
        Map<String, Integer> dailyScores = ploggingDAOS.stream()
                .collect(Collectors.groupingBy(
                        dao -> String.valueOf(dao.getDay()),
                        Collectors.summingInt(PloggingDAO::getScore)
                ));

        // DataList 생성
        List<DataList> dataList = allDates.stream()
                .map(date -> DataList.builder()
                        .day(String.valueOf(date.getDayOfMonth()))
                        .score(dailyScores.getOrDefault(String.valueOf(date.getDayOfMonth()), 0))
                        .build())
                .toList();

        // 평균 계산
        int totalScore = dataList.stream().mapToInt(DataList::getScore).sum();
        int averageScore = !dataList.isEmpty() ? totalScore / dataList.size() : 0;

        // ResponseStatisticsGetDTO 생성
        return ResponseStatisticsGetDTO.builder()
                .average(averageScore)
                .dataList(dataList)
                .build();
    }
}
