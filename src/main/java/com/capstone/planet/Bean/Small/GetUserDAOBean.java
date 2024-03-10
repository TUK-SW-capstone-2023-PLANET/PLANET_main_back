package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.UserDAO;
import com.capstone.planet.Model.DTO.ResponseUserAllGetDTO;
import com.capstone.planet.Repository.UserRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetUserDAOBean {

    UserRepositoryJPA userRepositoryJPA;

    @Autowired
    public GetUserDAOBean(UserRepositoryJPA userRepositoryJPA) {
        this.userRepositoryJPA = userRepositoryJPA;
    }

    // 유저 객체 가져오기
    public UserDAO exec(Long userHandleId){
        return userRepositoryJPA.findById(userHandleId).orElse(null);
    }

    // 전체 유저 정보 가져오기
    public ResponseUserAllGetDTO exec(){

        ResponseUserAllGetDTO responseUserAllGetDTO = new ResponseUserAllGetDTO();

        responseUserAllGetDTO.setUserCount(userRepositoryJPA.getTotalUserCount());
        responseUserAllGetDTO.setTrashCount(userRepositoryJPA.getTotalTrashCount());
        responseUserAllGetDTO.setDistance(userRepositoryJPA.getTotalDistanceSum());

        return responseUserAllGetDTO;
    }

    // 대학교에 해당하는 유저 전부 가져오기
    public List<UserDAO> exec(String universityName){
        return userRepositoryJPA.findByUniversityNameOrderByScoreDesc(universityName);
    }
}
