package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.PloggingDAO;
import com.capstone.planet.Model.DTO.LocationDTO;
import com.capstone.planet.Model.DTO.ResponsePloggingGetDTO;
import com.capstone.planet.Model.DTO.TrashDTO;
import com.capstone.planet.Model.DTO.TrashInfoDTO;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Component
public class CreatePloggingDTOBean {

    public ResponsePloggingGetDTO exec(PloggingDAO ploggingDAO, List<LocationDTO> locationDTOS, List<TrashDTO> trashDTOS, List<Map<String, List<TrashInfoDTO>>> mapList){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
        String formattedDateTime = ploggingDAO.getUploadTime().format(formatter);

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("a h시 m분");
        String formattedUploadTime1 = ploggingDAO.getUploadTime().format(formatter1);

        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("a h시 m분");
        String formattedUploadTime2 = ploggingDAO.getUploadTime().plusSeconds(ploggingDAO.getPloggingTime()).format(formatter2);

        double distance = ploggingDAO.getDistance();

        // 두 번째 자리까지 반올림
        BigDecimal roundedDistance = new BigDecimal(distance).setScale(2, RoundingMode.HALF_UP);


        return ResponsePloggingGetDTO.builder()
                .ploggingId(ploggingDAO.getPloggingId())
                .uploadTime(formattedDateTime)
                .runningTime(formattedUploadTime1 + " ~ " + formattedUploadTime2)
                .ploggingTime(ploggingDAO.getPloggingTime())
                .trashCount(ploggingDAO.getTrashCount())
                .distance(roundedDistance.doubleValue())
                .kcal(ploggingDAO.getKcal())
                .pace(ploggingDAO.getPace())
                .score(ploggingDAO.getScore())
                .location(locationDTOS)
                .firstLocation(locationDTOS.get(0))
                .middleLocation(locationDTOS.get(locationDTOS.size()/2))
                .lastLocation(locationDTOS.get(locationDTOS.size()-1))
                .trash(trashDTOS)
                .trashInfo(mapList)
                .build();

    }
}
