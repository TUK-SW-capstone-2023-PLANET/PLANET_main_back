package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.PloggingDAO;
import com.capstone.planet.Model.DTO.ResponsePloggingGetsDTO;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
public class CreatePloggingDTOsBean {

    public ResponsePloggingGetsDTO exec(PloggingDAO ploggingDAO){

        // LocalTime으로 변환
        LocalTime endTime = ploggingDAO.getUploadTime().toLocalTime();

        // Duration 객체로 변환하여 시작 시간 계산
        Duration duration = Duration.ofSeconds(ploggingDAO.getPloggingTime());
        LocalTime startTime = endTime.minus(duration);

        // 포맷터 정의
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        // 시간 범위 포맷팅
        String formattedStartTime = startTime.format(timeFormatter);
        String formattedEndTime = endTime.format(timeFormatter);

        // 경과 시간 계산 (분 단위)
        long minutesBetween = duration.toMinutes();

        // 결과 문자열 생성
        String ploggingTime = formattedStartTime + " ~ " + formattedEndTime + " (" + minutesBetween + "min)";

        double distance = ploggingDAO.getDistance();

        // 두 번째 자리까지 반올림
        BigDecimal roundedDistance = new BigDecimal(distance).setScale(2, RoundingMode.HALF_UP);
        double v = roundedDistance.doubleValue();
        System.out.println("v = " + v);

        return ResponsePloggingGetsDTO.builder()
                .ploddingId(ploggingDAO.getPloggingId())
                .userId(ploggingDAO.getUserId())
                .imageUrl(ploggingDAO.getImageUrl())
                .address(ploggingDAO.getAddress())
                .trashCount(ploggingDAO.getTrashCount())
                .distance(Double.toString(v))
                .ploggingTime(ploggingTime)
                .build();
    }
}
