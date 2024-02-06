package com.capstone.planet.Service;

import com.capstone.planet.Bean.GetUserAllBean;
import com.capstone.planet.Bean.GetUserBean;
import com.capstone.planet.Bean.SaveUserBean;
import com.capstone.planet.Bean.UpdateUserBean;
import com.capstone.planet.Model.DTO.RequestUserSaveDTO;
import com.capstone.planet.Model.DTO.RequestUserUpdateDTO;
import com.capstone.planet.Model.DTO.ResponseUserAllGetDTO;
import com.capstone.planet.Model.DTO.ResponseUserGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    GetUserBean getUserBean;
    GetUserAllBean getUserAllBean;
    SaveUserBean saveUserBean;
    UpdateUserBean updateUserBean;

    @Autowired
    public UserService(GetUserBean getUserBean, GetUserAllBean getUserAllBean, SaveUserBean saveUserBean, UpdateUserBean updateUserBean) {
        this.getUserBean = getUserBean;
        this.getUserAllBean = getUserAllBean;
        this.saveUserBean = saveUserBean;
        this.updateUserBean = updateUserBean;
    }

    // 유저 조회
    public ResponseUserGetDTO getUser(Long userHandleId){
        return getUserBean.exec(userHandleId);
    }

    // 전체 유저 정보 조회
    public ResponseUserAllGetDTO getUserAllInfo(){
        return getUserAllBean.exec();
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
