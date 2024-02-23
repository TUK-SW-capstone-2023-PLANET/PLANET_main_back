package com.capstone.planet.Service;

import com.capstone.planet.Bean.SavePloggingBean;
import com.capstone.planet.Model.DTO.RequestPloggingSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PloggingService {

    SavePloggingBean savePloggingBean;

    @Autowired
    public PloggingService(SavePloggingBean savePloggingBean) {
        this.savePloggingBean = savePloggingBean;
    }

    // 플로깅 정보 저장
    public Long savePlogging(RequestPloggingSaveDTO requestPloggingSaveDTO){
        return savePloggingBean.exec(requestPloggingSaveDTO);
    }
}
