package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.CreateUniqueIdBean;
import com.capstone.planet.Bean.Small.CreateUserDAOBean;
import com.capstone.planet.Bean.Small.GetUserDAOBean;
import com.capstone.planet.Bean.Small.SaveUserDAOBean;
import com.capstone.planet.Model.DAO.UserDAO;
import com.capstone.planet.Model.DTO.RequestUserSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveUserBean {

    GetUserDAOBean getUserDAOBean;
    CreateUniqueIdBean createUniqueIdBean;
    CreateUserDAOBean createUserDAOBean;
    SaveUserDAOBean saveUserDAOBean;

    @Autowired
    public SaveUserBean(GetUserDAOBean getUserDAOBean, CreateUniqueIdBean createUniqueIdBean, CreateUserDAOBean createUserDAOBean, SaveUserDAOBean saveUserDAOBean) {
        this.getUserDAOBean = getUserDAOBean;
        this.createUniqueIdBean = createUniqueIdBean;
        this.createUserDAOBean = createUserDAOBean;
        this.saveUserDAOBean = saveUserDAOBean;
    }

    // 유저 회원가입
    public Long exec(RequestUserSaveDTO requestUserSaveDTO){

        // 유저 아이디 중복 확인
        UserDAO duplicateuserDAO = getUserDAOBean.exec(requestUserSaveDTO.getUserId());
        if (duplicateuserDAO != null) return null;

        // 아이디 생성
        Long userHandleId = createUniqueIdBean.exec();

        // UserDAO 객체 생성
        UserDAO userDAO = createUserDAOBean.exec(userHandleId, requestUserSaveDTO);

        // 유저 저장
        saveUserDAOBean.exec(userDAO);

        return userHandleId;
    }
}
