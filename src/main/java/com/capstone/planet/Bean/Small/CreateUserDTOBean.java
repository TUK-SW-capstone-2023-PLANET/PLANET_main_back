package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.SeasonDAO;
import com.capstone.planet.Model.DAO.UserDAO;
import com.capstone.planet.Model.DTO.ResponseSeasonUserGetDTO;
import com.capstone.planet.Model.DTO.ResponseUserGetDTO;
import com.capstone.planet.Model.DTO.ResponseUserRankGetDTO;
import com.capstone.planet.Model.DTO.ResponseUserRanksGetDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Page<ResponseUserRanksGetDTO> exec(Page<UserDAO> userDAOS){

        List<ResponseUserRanksGetDTO> responseList = new ArrayList<>();

        int pageSize = userDAOS.getPageable().getPageSize();
        int pageNumber = userDAOS.getPageable().getPageNumber();
        int i = pageSize * pageNumber + 1;


        for (UserDAO userDAO : userDAOS) {
            ResponseUserRanksGetDTO responseUserRanksGetDTO = new ResponseUserRanksGetDTO();
            responseUserRanksGetDTO.setNickName(userDAO.getNickName());
            responseUserRanksGetDTO.setRank(i);
            responseUserRanksGetDTO.setScore(userDAO.getScore());
            responseUserRanksGetDTO.setImageUrl(userDAO.getImageUrl());
            responseUserRanksGetDTO.setUniversityLogo(userDAO.getUniversityLogo());

            responseList.add(responseUserRanksGetDTO);
            i++;
        }


        return new PageImpl<>(responseList, userDAOS.getPageable(), userDAOS.getTotalElements());
    }
}
