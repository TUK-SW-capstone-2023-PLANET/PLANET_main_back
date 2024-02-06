package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.CreateUserDTOBean;
import com.capstone.planet.Bean.Small.GetUserDAOBean;
import com.capstone.planet.Model.DAO.UserDAO;
import com.capstone.planet.Model.DTO.ResponseUserGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetUserBean {

    GetUserDAOBean getUserDAOBean;
    CreateUserDTOBean createUserDTOBean;

    @Autowired
    public GetUserBean(GetUserDAOBean getUserDAOBean, CreateUserDTOBean createUserDTOBean) {
        this.getUserDAOBean = getUserDAOBean;
        this.createUserDTOBean = createUserDTOBean;
    }

    // 유저 정보 조회
    public ResponseUserGetDTO exec(Long userHandleId){

        // 유저 객체 가져오기
        UserDAO userDAO = getUserDAOBean.exec(userHandleId);
        if (userDAO == null) return null;

        // 유저 DTO 반환
        return createUserDTOBean.exec(userDAO);
    }
}
