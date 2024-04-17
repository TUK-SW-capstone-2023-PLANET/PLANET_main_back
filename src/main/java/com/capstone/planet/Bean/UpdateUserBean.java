package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.GetUserDAOBean;
import com.capstone.planet.Bean.Small.SaveUserDAOBean;
import com.capstone.planet.Bean.Small.UpdateUserDAOBean;
import com.capstone.planet.Model.DAO.UserDAO;
import com.capstone.planet.Model.DTO.RequestUserUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateUserBean {

    GetUserDAOBean getUserDAOBean;
    UpdateUserDAOBean updateUserDAOBean;
    SaveUserDAOBean saveUserDAOBean;

    @Autowired
    public UpdateUserBean(GetUserDAOBean getUserDAOBean, UpdateUserDAOBean updateUserDAOBean, SaveUserDAOBean saveUserDAOBean) {
        this.getUserDAOBean = getUserDAOBean;
        this.updateUserDAOBean = updateUserDAOBean;
        this.saveUserDAOBean = saveUserDAOBean;
    }

    // 유저 정보 수정
    public Long exec(RequestUserUpdateDTO requestUserUpdateDTO){

        // 유저 객체 가져오기
        UserDAO userDAO = getUserDAOBean.exec(requestUserUpdateDTO.getUserId());
        if (userDAO == null) return null;

        // 유저 정보 수정
        updateUserDAOBean.exec(userDAO, requestUserUpdateDTO);

        // 유저 저장
        saveUserDAOBean.exec(userDAO);

        return userDAO.getUserId();
    }

}
