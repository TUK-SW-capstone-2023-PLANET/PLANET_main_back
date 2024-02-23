package com.capstone.planet.Service;

import com.capstone.planet.Bean.GetPloggingIdBean;
import com.capstone.planet.Bean.SavePloggingBean;
import com.capstone.planet.Model.DTO.RequestPloggingSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PloggingService {

    GetPloggingIdBean getPloggingIdBean;
    SavePloggingBean savePloggingBean;

    @Autowired
    public PloggingService(GetPloggingIdBean getPloggingIdBean, SavePloggingBean savePloggingBean) {
        this.getPloggingIdBean = getPloggingIdBean;
        this.savePloggingBean = savePloggingBean;
    }

    // 플로깅 시작시 아이디 생성
    public Long getPloggingId(){
        return getPloggingIdBean.exec();
    }

    // 플로깅 정보 저장
    public Long savePlogging(RequestPloggingSaveDTO requestPloggingSaveDTO){
        return savePloggingBean.exec(requestPloggingSaveDTO);
    }
}
