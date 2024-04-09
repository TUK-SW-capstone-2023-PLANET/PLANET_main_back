package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.UserDAO;
import com.capstone.planet.Model.DTO.ResponseUserAllGetDTO;
import com.capstone.planet.Repository.UserRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    // 대학교에 해당하는 유저 전부 가져오기
    public List<UserDAO> exec(String universityName){
        return userRepositoryJPA.findByUniversityNameOrderByScoreDesc(universityName);
    }

    // 유저 랭킹 3개
    public List<UserDAO> exec(String check1, String check2){
        return userRepositoryJPA.findTop3ByOrderByScoreDesc();
    }

    // 유저 랭킹 점수 순으로 전부 가져오기
    public List<UserDAO> exec(){
        return userRepositoryJPA.findAllByOrderByScoreDesc();
    }

    public Page<UserDAO> exec(Pageable pageable){
        return userRepositoryJPA.findAll(pageable);
    }
}
