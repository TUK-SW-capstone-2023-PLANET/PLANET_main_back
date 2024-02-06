package com.capstone.planet.Service;

import com.capstone.planet.Bean.GetUserBean;
import com.capstone.planet.Bean.SaveUserBean;
import com.capstone.planet.Model.DTO.RequestUserSaveDTO;
import com.capstone.planet.Model.DTO.ResponseUserGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    GetUserBean getUserBean;
    SaveUserBean saveUserBean;

    @Autowired
    public UserService(GetUserBean getUserBean, SaveUserBean saveUserBean) {
        this.getUserBean = getUserBean;
        this.saveUserBean = saveUserBean;
    }

    // 유저 조회
    public ResponseUserGetDTO getUser(Long userHandleId){
        return getUserBean.exec(userHandleId);
    }

    // 유저 회원가입
    public Long saveUser(RequestUserSaveDTO requestUserSaveDTO){
        return saveUserBean.exec(requestUserSaveDTO);
    }
}
