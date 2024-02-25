package com.capstone.planet.Service;

import com.capstone.planet.Bean.SavePloggingLiveBean;
import com.capstone.planet.Model.DTO.RequestPloggingLiveSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PloggingLiveService {

    SavePloggingLiveBean savePloggingLiveBean;

    @Autowired
    public PloggingLiveService(SavePloggingLiveBean savePloggingLiveBean) {
        this.savePloggingLiveBean = savePloggingLiveBean;
    }

    // 실시간 플로깅 쓰레기 사진 저장
    public List<Map<String, Integer>> savePloggingLiveDAO(RequestPloggingLiveSaveDTO requestPloggingLiveSaveDTO){
        return savePloggingLiveBean.exec(requestPloggingLiveSaveDTO);
    }
}
