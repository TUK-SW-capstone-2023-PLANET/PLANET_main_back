package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.UserDAO;
import com.capstone.planet.Model.DTO.ResponseUserDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateUserDTOBean {

    // 유저 DTO 생성
    public ResponseUserDTO exec(UserDAO userDAO){

        ResponseUserDTO responseUserDTO = new ResponseUserDTO();

        responseUserDTO.setUserHandleId(userDAO.getUserHandleId());
        responseUserDTO.setUserId(userDAO.getUserId());
        responseUserDTO.setPasswd(userDAO.getPasswd());
        responseUserDTO.setNickName(userDAO.getNickName());
        responseUserDTO.setImageUrl(userDAO.getImageUrl());
        responseUserDTO.setAddress(userDAO.getAddress());
        responseUserDTO.setPloggingCount(userDAO.getPloggingCount());
        responseUserDTO.setTrashCount(userDAO.getTrashCount());
        responseUserDTO.setTotalDistance(userDAO.getTotalDistance());
        responseUserDTO.setScore(userDAO.getScore());

        return responseUserDTO;
    }
}
