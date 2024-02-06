package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.UserDAO;
import com.capstone.planet.Repository.UserRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    // 유저 중복 확인
    public UserDAO exec(String userId){
        return userRepositoryJPA.findByUserId(userId);
    }


}
