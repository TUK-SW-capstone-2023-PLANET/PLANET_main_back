package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.PloggingLiveDAO;
import com.capstone.planet.Model.DTO.RequestPloggingLiveSaveDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CreatePloggingLiveDAOBean {

    // 실시간 플로깅 쓰레기 사진 DAO 생성
    public PloggingLiveDAO exec(Long ploggingLiveId, RequestPloggingLiveSaveDTO requestPloggingLiveSaveDTO) {

        PloggingLiveDAO ploggingLiveDAO = new PloggingLiveDAO();

        ploggingLiveDAO.setPloggingLiveId(ploggingLiveId);
        ploggingLiveDAO.setPloggingId(requestPloggingLiveSaveDTO.getPloggingId());
        ploggingLiveDAO.setUserId(requestPloggingLiveSaveDTO.getUserId());
        ploggingLiveDAO.setImageUrl(requestPloggingLiveSaveDTO.getImageUrl());
        ploggingLiveDAO.setLatitude(requestPloggingLiveSaveDTO.getLatitude());
        ploggingLiveDAO.setLongitude(requestPloggingLiveSaveDTO.getLongitude());
        ploggingLiveDAO.setUploadTime(LocalDateTime.now());

        return ploggingLiveDAO;
    }
}
