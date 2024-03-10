package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.UserDAO;
import com.capstone.planet.Model.DTO.RequestUserUpdateDTO;
import org.springframework.stereotype.Component;

@Component
public class UpdateUserDAOBean {

    // 유저 정보 수정
    public UserDAO exec(UserDAO userDAO, RequestUserUpdateDTO requestUserUpdateDTO){

        userDAO.setLoginId(requestUserUpdateDTO.getLoginId());
        userDAO.setPasswd(requestUserUpdateDTO.getPasswd());
        userDAO.setNickName(requestUserUpdateDTO.getNickName());
        userDAO.setImageUrl(requestUserUpdateDTO.getImageUrl());
        userDAO.setAddress(requestUserUpdateDTO.getAddress());

        return userDAO;
    }
}
