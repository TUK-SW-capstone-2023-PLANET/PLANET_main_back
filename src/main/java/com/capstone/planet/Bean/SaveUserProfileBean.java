package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.GetUserDAOBean;
import com.capstone.planet.Bean.Small.SaveUserDAOBean;
import com.capstone.planet.Model.DAO.UserDAO;
import com.capstone.planet.Model.DTO.RequestUserProfileSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveUserProfileBean {

    GetUserDAOBean getUserDAOBean;
    SaveUserDAOBean saveUserDAOBean;

    @Autowired
    public SaveUserProfileBean(GetUserDAOBean getUserDAOBean, SaveUserDAOBean saveUserDAOBean) {
        this.getUserDAOBean = getUserDAOBean;
        this.saveUserDAOBean = saveUserDAOBean;
    }

    // 유저 프로필 저장
    public Long exec(RequestUserProfileSaveDTO requestUserProfileSaveDTO){

        UserDAO userDAO = getUserDAOBean.exec(requestUserProfileSaveDTO.getEmail(), "", 0L);

        userDAO.setHeight(requestUserProfileSaveDTO.getHeight());
        userDAO.setWeight(requestUserProfileSaveDTO.getWeight());
        userDAO.setGender(requestUserProfileSaveDTO.getGender());
        userDAO.setNickName(requestUserProfileSaveDTO.getNickName());
        userDAO.setPasswd(requestUserProfileSaveDTO.getPassword());

        saveUserDAOBean.exec(userDAO);

        return userDAO.getUserId();
    }
}
