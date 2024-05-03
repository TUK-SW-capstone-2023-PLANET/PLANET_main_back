package com.capstone.planet.Service;

import com.capstone.planet.Bean.GetPloggingBean;
import com.capstone.planet.Bean.GetPloggingIdBean;
import com.capstone.planet.Bean.SavePloggingBean;
import com.capstone.planet.Model.DTO.RequestPloggingSaveDTO;
import com.capstone.planet.Model.DTO.ResponsePloggingGetDTO;
import com.capstone.planet.Model.DTO.ResponsePloggingStartDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PloggingService {

    GetPloggingIdBean getPloggingIdBean;
    GetPloggingBean getPloggingBean;
    SavePloggingBean savePloggingBean;

    @Autowired
    public PloggingService(GetPloggingIdBean getPloggingIdBean, GetPloggingBean getPloggingBean, SavePloggingBean savePloggingBean) {
        this.getPloggingIdBean = getPloggingIdBean;
        this.getPloggingBean = getPloggingBean;
        this.savePloggingBean = savePloggingBean;
    }

    // 플로깅 시작시 아이디 생성
    public ResponsePloggingStartDTO getPloggingId(Long userId){
        return getPloggingIdBean.exec(userId);
    }

    // 플로깅 정보 조회
    public ResponsePloggingGetDTO getPlogging(Long ploggingId){
        return getPloggingBean.exec(ploggingId);
    }

    // 플로깅 정보 저장
    public Long savePlogging(RequestPloggingSaveDTO requestPloggingSaveDTO) throws IOException {
        return savePloggingBean.exec(requestPloggingSaveDTO);
    }
}
