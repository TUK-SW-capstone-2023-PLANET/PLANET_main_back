package com.capstone.planet.Service;

import com.capstone.planet.Bean.*;
import com.capstone.planet.Model.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    GetUniversityInfoBean getUniversityInfoBean;
    CheckUserNameBean checkUserNameBean;
    GetUserRankBean getUserRankBean;
    GetUserBean getUserBean;
    GetUserAllBean getUserAllBean;
    SaveUserProfileBean saveUserProfileBean;
    SaveUserBean saveUserBean;
    UpdateUserBean updateUserBean;
    GetUserTop3Bean getUserTop3Bean;
    GetUniversityUsersBean getUniversityUsersBean;
    GetUniversityUserBean getUniversityUserBean;
    GetUniversityUserTop3Bean getUniversityUserTop3Bean;
    GetUniversityUser4Bean getUniversityUser4Bean;

    @Autowired
    public UserService(GetUniversityInfoBean getUniversityInfoBean, CheckUserNameBean checkUserNameBean, GetUserRankBean getUserRankBean, GetUserBean getUserBean, GetUserAllBean getUserAllBean, SaveUserProfileBean saveUserProfileBean, SaveUserBean saveUserBean, UpdateUserBean updateUserBean, GetUserTop3Bean getUserTop3Bean, GetUniversityUsersBean getUniversityUsersBean, GetUniversityUserBean getUniversityUserBean, GetUniversityUserTop3Bean getUniversityUserTop3Bean, GetUniversityUser4Bean getUniversityUser4Bean) {
        this.getUniversityInfoBean = getUniversityInfoBean;
        this.checkUserNameBean = checkUserNameBean;
        this.getUserRankBean = getUserRankBean;
        this.getUserBean = getUserBean;
        this.getUserAllBean = getUserAllBean;
        this.saveUserProfileBean = saveUserProfileBean;
        this.saveUserBean = saveUserBean;
        this.updateUserBean = updateUserBean;
        this.getUserTop3Bean = getUserTop3Bean;
        this.getUniversityUsersBean = getUniversityUsersBean;
        this.getUniversityUserBean = getUniversityUserBean;
        this.getUniversityUserTop3Bean = getUniversityUserTop3Bean;
        this.getUniversityUser4Bean = getUniversityUser4Bean;
    }

    // 유저 id로 대학교 정보 가져오기
    public ResponseUniversityInfoGetDTO getUniversityInfo(Long userId){
        return getUniversityInfoBean.exec(userId);
    }

    // 유저 이름 중복 체크
    public boolean checkUserName(String nickName){
        return checkUserNameBean.exec(nickName);
    }

    // 유저 조회
    public ResponseUserGetDTO getUser(Long userHandleId){
        return getUserBean.exec(userHandleId);
    }

    // 유저 프로필 저장
    public Long saveUserProfile(RequestUserProfileSaveDTO requestUserProfileSaveDTO){
        return saveUserProfileBean.exec(requestUserProfileSaveDTO);
    }

    // 유저 회원가입
    public Map<String, Object> saveUser(Map<String, Object> certify){
        return saveUserBean.exec(certify);
    }

    // 유저 정보수정
    public Long updateUser(RequestUserUpdateDTO requestUserUpdateDTO){
        return updateUserBean.exec(requestUserUpdateDTO);
    }

    // 나의 플로깅 랭킹 조회
    public ResponseUserRanksGetDTO getMyRank(Long userId){
        return getUserRankBean.exec(userId);
    }

    // 유저 랭킹 탑 3 조회
    public List<ResponseUserRankGetDTO> getUserTop3(){
        return getUserTop3Bean.exec();
    }

    // 유저 랭킹 전체조회
    public Page<ResponseUserRanksGetDTO> getUserAll(Pageable pageable){
        return getUserAllBean.exec(pageable);
    }


    // 나의 대학교 유저 랭킹 조회
    public ResponseUserUniversityGetDTO getMyUniversityRank(Long userId){
        return getUniversityUserBean.exec(userId);
    }

    // 대학교 소속 유저 전체조회
    public Page<ResponseUserUniversityGetDTO> getUniversityUser(Long userId, Pageable pageable){
        return getUniversityUsersBean.exec(userId, pageable);
    }

    // 대학교 소속 유저 4개조회
    public List<Map<Integer, ResponseUserUniversity4GetDTO>> getUniversity4User(Long userHandleId){
        return getUniversityUser4Bean.exec(userHandleId);
    }
}
