package com.capstone.planet.Service;

import com.capstone.planet.Bean.*;
import com.capstone.planet.Model.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    GetUserBean getUserBean;
    GetUserAllBean getUserAllBean;
    SaveUserBean saveUserBean;
    UpdateUserBean updateUserBean;
    GetUniversityUserBean getUniversityUserBean;
    GetUniversityUserTop3Bean getUniversityUserTop3Bean;

    @Autowired
    public UserService(GetUserBean getUserBean, GetUserAllBean getUserAllBean, SaveUserBean saveUserBean, UpdateUserBean updateUserBean, GetUniversityUserBean getUniversityUserBean, GetUniversityUserTop3Bean getUniversityUserTop3Bean) {
        this.getUserBean = getUserBean;
        this.getUserAllBean = getUserAllBean;
        this.saveUserBean = saveUserBean;
        this.updateUserBean = updateUserBean;
        this.getUniversityUserBean = getUniversityUserBean;
        this.getUniversityUserTop3Bean = getUniversityUserTop3Bean;
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

    // 대학교 소속 유저 탑3 랭킹 조회
    public List<ResponseUserUniversityTop3GetDTO> getUniversityUserTop3(Long userHandleId){
        return getUniversityUserTop3Bean.exec(userHandleId);
    }

    // 대학교 소속 유저 전체조회
    public List<Map<Integer, ResponseUserUniversityGetDTO>> getUniversityUser(Long userHandleId){
        return getUniversityUserBean.exec(userHandleId);
    }
}
