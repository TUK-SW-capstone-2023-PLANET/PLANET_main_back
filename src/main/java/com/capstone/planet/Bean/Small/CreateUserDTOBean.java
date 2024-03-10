package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.UserDAO;
import com.capstone.planet.Model.DTO.ResponseUserGetDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateUserDTOBean {

    // 유저 DTO 생성
    public ResponseUserGetDTO exec(UserDAO userDAO){

        ResponseUserGetDTO responseUserGetDTO = new ResponseUserGetDTO();

        responseUserGetDTO.setUserId(userDAO.getUserId());
        responseUserGetDTO.setLoginId(userDAO.getLoginId());
        responseUserGetDTO.setPasswd(userDAO.getPasswd());
        responseUserGetDTO.setNickName(userDAO.getNickName());
        responseUserGetDTO.setImageUrl(userDAO.getImageUrl());
        responseUserGetDTO.setAddress(userDAO.getAddress());
        responseUserGetDTO.setPloggingCount(userDAO.getPloggingCount());
        responseUserGetDTO.setTrashCount(userDAO.getTrashCount());
        responseUserGetDTO.setTotalDistance(userDAO.getTotalDistance());
        responseUserGetDTO.setScore(userDAO.getScore());

        return responseUserGetDTO;
    }
}
