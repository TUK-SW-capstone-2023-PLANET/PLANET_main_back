package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.UserDAO;
import com.capstone.planet.Model.DTO.RequestUserUpdateDTO;
import org.springframework.stereotype.Component;

@Component
public class UpdateUserDAOBean {

    // 유저 정보 수정
    public void exec(UserDAO userDAO, RequestUserUpdateDTO requestUserUpdateDTO){

        userDAO.setImageUrl(requestUserUpdateDTO.getImageUrl());
        userDAO.setNickName(requestUserUpdateDTO.getNickName());
        userDAO.setMessage(requestUserUpdateDTO.getMessage());
        userDAO.setPasswd(requestUserUpdateDTO.getPasswd());
        userDAO.setWeight(requestUserUpdateDTO.getWeight());
        userDAO.setHeight(requestUserUpdateDTO.getHeight());
    }
}
