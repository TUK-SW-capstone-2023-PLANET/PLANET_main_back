package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.*;
import com.capstone.planet.Model.DAO.PloggingLiveDAO;
import com.capstone.planet.Model.DTO.LiveTrashDTO;
import com.capstone.planet.Model.DTO.RequestPloggingLiveSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SavePloggingLiveBean {

    CreateUniqueIdBean createUniqueIdBean;
    CreatePloggingLiveDAOBean createPloggingLiveDAOBean;
    SavePloggingLiveDAOBean savePloggingLiveDAOBean;
    RestTemplate restTemplate;
    GetAddressBean getAddressBean;
    CheckNameBean checkNameBean;
    CreateLiveTrashDTOBean createLiveTrashDTOBean;

    @Autowired
    public SavePloggingLiveBean(CheckNameBean checkNameBean, CreateUniqueIdBean createUniqueIdBean, CreatePloggingLiveDAOBean createPloggingLiveDAOBean, SavePloggingLiveDAOBean savePloggingLiveDAOBean, RestTemplateBuilder restTemplateBuilder, GetAddressBean getAddressBean, CreateLiveTrashDTOBean createLiveTrashDTOBean) {
        this.checkNameBean = checkNameBean;
        this.createUniqueIdBean = createUniqueIdBean;
        this.createPloggingLiveDAOBean = createPloggingLiveDAOBean;
        this.savePloggingLiveDAOBean = savePloggingLiveDAOBean;
        this.restTemplate = restTemplateBuilder.build();
        this.getAddressBean = getAddressBean;
        this.createLiveTrashDTOBean = createLiveTrashDTOBean;
    }

    // 실시간 플로깅 쓰레기 사진 저장
    public List<LiveTrashDTO> exec(RequestPloggingLiveSaveDTO requestPloggingLiveSaveDTO) {

        // 고유 아이디 생성
        long ploggingLiveId = createUniqueIdBean.exec();

        // 쓰레기 위치 주소 가져오기
        String address = getAddressBean.exec(requestPloggingLiveSaveDTO.getLongitude(), requestPloggingLiveSaveDTO.getLatitude());

        // DAO 생성
        PloggingLiveDAO ploggingLiveDAO = createPloggingLiveDAOBean.exec(ploggingLiveId, address, requestPloggingLiveSaveDTO);

        // 플로깅 라이브 저장
        savePloggingLiveDAOBean.exec(ploggingLiveDAO);

        // 더미 데이터 전송
        return createLiveTrashDTOBean.exec(ploggingLiveDAO.getPloggingId());
    }
}
