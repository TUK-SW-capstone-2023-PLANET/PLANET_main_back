package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.CreatePloggingDAOBean;
import com.capstone.planet.Bean.Small.CreateUniqueIdBean;
import com.capstone.planet.Bean.Small.SavePloggingDAOBean;
import com.capstone.planet.Model.DAO.PloggingDAO;
import com.capstone.planet.Model.DTO.RequestPloggingSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SavePloggingBean {

    CreateUniqueIdBean createUniqueIdBean;
    CreatePloggingDAOBean createPloggingDAOBean;
    SavePloggingDAOBean savePloggingDAOBean;

    @Autowired
    public SavePloggingBean(CreateUniqueIdBean createUniqueIdBean, CreatePloggingDAOBean createPloggingDAOBean, SavePloggingDAOBean savePloggingDAOBean) {
        this.createUniqueIdBean = createUniqueIdBean;
        this.createPloggingDAOBean = createPloggingDAOBean;
        this.savePloggingDAOBean = savePloggingDAOBean;
    }

    // 플로깅 저장
    public Long exec(RequestPloggingSaveDTO requestPloggingSaveDTO){

        // 플로깅 DAO 생성
        PloggingDAO ploggingDAO = createPloggingDAOBean.exec(requestPloggingSaveDTO);

        // 플로깅 저장
        savePloggingDAOBean.exec(ploggingDAO);

        return requestPloggingSaveDTO.getPloggingId();
    }
}
