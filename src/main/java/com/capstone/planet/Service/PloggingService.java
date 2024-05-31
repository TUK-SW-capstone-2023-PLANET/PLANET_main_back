package com.capstone.planet.Service;

import com.capstone.planet.Bean.GetPloggingBean;
import com.capstone.planet.Bean.GetPloggingIdBean;
import com.capstone.planet.Bean.GetPloggingsBean;
import com.capstone.planet.Bean.SavePloggingBean;
import com.capstone.planet.Model.DTO.RequestPloggingSaveDTO;
import com.capstone.planet.Model.DTO.ResponsePloggingGetDTO;
import com.capstone.planet.Model.DTO.ResponsePloggingGetsDTO;
import com.capstone.planet.Model.DTO.ResponsePloggingStartDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class PloggingService {

    GetPloggingIdBean getPloggingIdBean;
    GetPloggingBean getPloggingBean;
    GetPloggingsBean getPloggingsBean;
    SavePloggingBean savePloggingBean;

    @Autowired
    public PloggingService(GetPloggingIdBean getPloggingIdBean, GetPloggingBean getPloggingBean, GetPloggingsBean getPloggingsBean, SavePloggingBean savePloggingBean) {
        this.getPloggingIdBean = getPloggingIdBean;
        this.getPloggingBean = getPloggingBean;
        this.getPloggingsBean = getPloggingsBean;
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

    // 다이어리 플로깅 정보 조회
    public List<Map<Integer, List<ResponsePloggingGetsDTO>>> getPloggings(Long userId, String year, String month){
        return getPloggingsBean.exec(userId, year, month);
    }

    // 플로깅 정보 저장
    public Long savePlogging(RequestPloggingSaveDTO requestPloggingSaveDTO) throws IOException {
        return savePloggingBean.exec(requestPloggingSaveDTO);
    }
}
