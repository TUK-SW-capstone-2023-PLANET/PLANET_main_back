package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.CreateUserDAOBean;
import com.capstone.planet.Bean.Small.GetUserDAOBean;
import com.capstone.planet.Bean.Small.SaveUserDAOBean;
import com.capstone.planet.Model.DAO.UserDAO;
import com.capstone.planet.Model.DTO.RequestUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SaveUserBean {

    GetUserDAOBean getUserDAOBean;
    CreateUserDAOBean createUserDAOBean;
    SaveUserDAOBean saveUserDAOBean;

    @Autowired
    public SaveUserBean(GetUserDAOBean getUserDAOBean, CreateUserDAOBean createUserDAOBean, SaveUserDAOBean saveUserDAOBean) {
        this.getUserDAOBean = getUserDAOBean;
        this.createUserDAOBean = createUserDAOBean;
        this.saveUserDAOBean = saveUserDAOBean;
    }

    // 유저 회원가입
    public UUID exec(RequestUserDTO requestUserDTO){

        // 유저 아이디 중복 확인
        UserDAO duplicateuserDAO = getUserDAOBean.exec(requestUserDTO.getUserid());
        if (duplicateuserDAO != null) return null;

        // 아이디 생성
        UUID userHandleId = UUID.randomUUID();

        // UserDAO 객체 생성
        UserDAO userDAO = createUserDAOBean.exec(userHandleId, requestUserDTO);

        // 유저 저장
        saveUserDAOBean.exec(userDAO);

        return userHandleId;
    }
}
