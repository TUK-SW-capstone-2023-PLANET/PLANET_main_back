package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.UserDAO;
import com.capstone.planet.Model.DTO.RequestUserDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateUserDAOBean {

    public UserDAO exec(Long userHandleId, RequestUserDTO requestUserDTO){
        UserDAO userDAO = new UserDAO();

        userDAO.setUserHandleId(userHandleId);
        userDAO.setUserId(requestUserDTO.getUserid());
        userDAO.setPasswd(requestUserDTO.getPasswd());
        userDAO.setNickName(requestUserDTO.getNickName());
        userDAO.setImageUrl(requestUserDTO.getImageUrl());
        userDAO.setAddress(requestUserDTO.getAddress());
        userDAO.setPloggingCount(0);
        userDAO.setTrashCount(0);
        userDAO.setTotalDistance(0.0);
        userDAO.setScore(0);

        return userDAO;
    }
}
