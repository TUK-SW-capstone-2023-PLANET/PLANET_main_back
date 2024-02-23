package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.CreateUniqueIdBean;
import com.capstone.planet.Bean.Small.GetPloggingDAOBean;
import com.capstone.planet.Model.DAO.PloggingDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetPloggingIdBean {

    CreateUniqueIdBean createUniqueIdBean;
    GetPloggingDAOBean getPloggingDAOBean;

    @Autowired
    public GetPloggingIdBean(CreateUniqueIdBean createUniqueIdBean, GetPloggingDAOBean getPloggingDAOBean) {
        this.createUniqueIdBean = createUniqueIdBean;
        this.getPloggingDAOBean = getPloggingDAOBean;
    }

    public Long exec(){

        // 아이디 생성
        Long ploggingId = createUniqueIdBean.exec();

        // 아이디 리턴
        PloggingDAO ploggingDAO = getPloggingDAOBean.exec(ploggingId);
        if (ploggingDAO != null) return exec();

        return ploggingId;
    }
}
