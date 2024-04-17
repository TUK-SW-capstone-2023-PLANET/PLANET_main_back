package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.CreateUniqueIdBean;
import com.capstone.planet.Bean.Small.GetPloggingDAOBean;
import com.capstone.planet.Bean.Small.GetUserDAOBean;
import com.capstone.planet.Model.DAO.PloggingDAO;
import com.capstone.planet.Model.DAO.UserDAO;
import com.capstone.planet.Model.DTO.ResponsePloggingStartDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class GetPloggingIdBean {

    CreateUniqueIdBean createUniqueIdBean;
    GetUserDAOBean getUserDAOBean;

    @Autowired
    public GetPloggingIdBean(CreateUniqueIdBean createUniqueIdBean, GetUserDAOBean getUserDAOBean) {
        this.createUniqueIdBean = createUniqueIdBean;
        this.getUserDAOBean = getUserDAOBean;
    }

    public ResponsePloggingStartDTO exec(Long userId){

        // 아이디 생성
        Long ploggingId = createUniqueIdBean.exec();

        UserDAO userDAO = getUserDAOBean.exec(userId);

        ResponsePloggingStartDTO responsePloggingStartDTO = new ResponsePloggingStartDTO();
        responsePloggingStartDTO.setPloggingId(ploggingId);
        responsePloggingStartDTO.setUserId(userId);
        responsePloggingStartDTO.setWeight(userDAO.getWeight());
        responsePloggingStartDTO.setHeight(userDAO.getHeight());


        return responsePloggingStartDTO;
    }
}
