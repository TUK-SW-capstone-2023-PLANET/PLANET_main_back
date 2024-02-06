package com.capstone.planet.Service;

import com.capstone.planet.Bean.SaveUserBean;
import com.capstone.planet.Model.DTO.RequestUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    SaveUserBean saveUserBean;

    @Autowired
    public UserService(SaveUserBean saveUserBean) {
        this.saveUserBean = saveUserBean;
    }

    // 유저 회원가입
    public Long saveUser(RequestUserDTO requestUserDTO){
        return saveUserBean.exec(requestUserDTO);
    }
}
