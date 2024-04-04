package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.UserDAO;
import com.capstone.planet.Model.DTO.ResponseUserGetDTO;
import com.capstone.planet.Model.DTO.ResponseUserRankGetDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    // 유저 랭킹 DTO 생성
    public List<ResponseUserRankGetDTO> exec(List<UserDAO> userDAOS){

        List<ResponseUserRankGetDTO> responseUserRankGetDTO = new ArrayList<>();


        for (UserDAO userDAO : userDAOS) {
            ResponseUserRankGetDTO responseUserGetDTO = new ResponseUserRankGetDTO();
            responseUserGetDTO.setNickName(userDAO.getNickName());
            responseUserGetDTO.setImageUrl(userDAO.getImageUrl());
            responseUserGetDTO.setScore(userDAO.getScore());

            responseUserRankGetDTO.add(responseUserGetDTO);
        }

        return responseUserRankGetDTO;
    }
}
