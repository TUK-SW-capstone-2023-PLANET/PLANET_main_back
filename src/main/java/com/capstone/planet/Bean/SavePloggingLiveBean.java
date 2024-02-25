package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.CreatePloggingLiveDAOBean;
import com.capstone.planet.Bean.Small.CreateUniqueIdBean;
import com.capstone.planet.Bean.Small.SavePloggingLiveDAOBean;
import com.capstone.planet.Model.DAO.PloggingLiveDAO;
import com.capstone.planet.Model.DTO.RequestPloggingLiveSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class SavePloggingLiveBean {

    CreateUniqueIdBean createUniqueIdBean;
    CreatePloggingLiveDAOBean createPloggingLiveDAOBean;
    SavePloggingLiveDAOBean savePloggingLiveDAOBean;

    @Autowired
    public SavePloggingLiveBean(CreateUniqueIdBean createUniqueIdBean, CreatePloggingLiveDAOBean createPloggingLiveDAOBean, SavePloggingLiveDAOBean savePloggingLiveDAOBean) {
        this.createUniqueIdBean = createUniqueIdBean;
        this.createPloggingLiveDAOBean = createPloggingLiveDAOBean;
        this.savePloggingLiveDAOBean = savePloggingLiveDAOBean;
    }

    // 실시간 플로깅 쓰레기 사진 저장
    public List<Map<String, Integer>> exec(RequestPloggingLiveSaveDTO requestPloggingLiveSaveDTO) {

        // 고유 아이디 생성
        long ploggingLiveId = createUniqueIdBean.exec();

        PloggingLiveDAO ploggingLiveDAO = createPloggingLiveDAOBean.exec(ploggingLiveId, requestPloggingLiveSaveDTO);

        // 플로깅 라이브 저장
        savePloggingLiveDAOBean.exec(ploggingLiveDAO);

        // AI 로 부터 데이터 받아서 처리하는 로직이 필요함

        // 더미 데이터 전송
        return List.of(Map.of("종이",1), Map.of("캔", 3), Map.of("플라스틱", 2), Map.of("유리", 1));
    }
}
