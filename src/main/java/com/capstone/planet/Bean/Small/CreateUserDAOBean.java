package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.UserDAO;
import com.capstone.planet.Model.DTO.RequestUserSaveDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateUserDAOBean {

    public UserDAO exec(Long userHandleId, RequestUserSaveDTO requestUserSaveDTO){
        UserDAO userDAO = new UserDAO();

        userDAO.setUserHandleId(userHandleId);
        userDAO.setUserId(requestUserSaveDTO.getUserId());
        userDAO.setPasswd(requestUserSaveDTO.getPasswd());
        userDAO.setNickName(requestUserSaveDTO.getNickName());
        userDAO.setImageUrl(requestUserSaveDTO.getImageUrl());
        userDAO.setAddress(requestUserSaveDTO.getAddress());
        userDAO.setPloggingCount(0);
        userDAO.setTrashCount(0);
        userDAO.setTotalDistance(0.0);
        userDAO.setScore(0);

        return userDAO;
    }
}
