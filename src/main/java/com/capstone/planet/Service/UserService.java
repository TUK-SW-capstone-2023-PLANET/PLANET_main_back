package com.capstone.planet.Service;

import com.capstone.planet.Bean.GetUserBean;
import com.capstone.planet.Bean.SaveUserBean;
import com.capstone.planet.Bean.UpdateUserBean;
import com.capstone.planet.Model.DTO.RequestUserSaveDTO;
import com.capstone.planet.Model.DTO.RequestUserUpdateDTO;
import com.capstone.planet.Model.DTO.ResponseUserGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    GetUserBean getUserBean;
    SaveUserBean saveUserBean;
    UpdateUserBean updateUserBean;

    @Autowired
    public UserService(GetUserBean getUserBean, SaveUserBean saveUserBean, UpdateUserBean updateUserBean) {
        this.getUserBean = getUserBean;
        this.saveUserBean = saveUserBean;
        this.updateUserBean = updateUserBean;
    }

    // 유저 조회
    public ResponseUserGetDTO getUser(Long userHandleId){
        return getUserBean.exec(userHandleId);
    }

    // 유저 회원가입
    public Long saveUser(RequestUserSaveDTO requestUserSaveDTO){
        return saveUserBean.exec(requestUserSaveDTO);
    }

    // 유저 정보수정
    public Long updateUser(RequestUserUpdateDTO requestUserUpdateDTO){
        return updateUserBean.exec(requestUserUpdateDTO);
    }
}
