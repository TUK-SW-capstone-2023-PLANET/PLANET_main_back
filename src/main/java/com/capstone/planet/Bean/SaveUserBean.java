package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.CreateUniqueIdBean;
import com.capstone.planet.Bean.Small.GetUniversityDAOBean;
import com.capstone.planet.Model.DAO.UniversityDAO;
import com.capstone.planet.Model.DAO.UserDAO;
import com.capstone.planet.Repository.UserRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SaveUserBean {

    UserRepositoryJPA userRepositoryJPA;
    CreateUniqueIdBean createUniqueIdBean;
    GetUniversityDAOBean getUniversityDAOBean;

    @Autowired
    public SaveUserBean(UserRepositoryJPA userRepositoryJPA, CreateUniqueIdBean createUniqueIdBean, GetUniversityDAOBean getUniversityDAOBean) {
        this.userRepositoryJPA = userRepositoryJPA;
        this.createUniqueIdBean = createUniqueIdBean;
        this.getUniversityDAOBean = getUniversityDAOBean;
    }

    // 유저 회원가입
    public Map<String, Object> exec(Map<String, Object> certify){

        String email = certify.get("certified_email").toString();
        String univName = certify.get("univName").toString();

        if (univName.equals("한국산업기술대학교")){
            certify.remove("univName");
            certify.put("univName", "한국공학대학교");
            email = email.replace("kpu", "tukorea");
            certify.remove("certified_email");
            certify.put("certified_email", email);
        }

        if (userRepositoryJPA.existsByEmail(certify.get("certified_email").toString())){
            certify.remove("message");
            certify.put("message", "이미 가입된 이메일입니다.");

            return certify;
        }

        UniversityDAO universityDAO = getUniversityDAOBean.exec(certify.get("univName").toString());

        UserDAO userDAO = new UserDAO();
        userDAO.setUserId(createUniqueIdBean.exec());
        userDAO.setEmail(certify.get("certified_email").toString());
        userDAO.setUniversityName(universityDAO.getName());
        userDAO.setUniversityLogo(universityDAO.getImageUrl());
        userDAO.setScore(0);
        userDAO.setPloggingCount(0);
        userDAO.setTrashCount(0);
        userDAO.setTotalDistance(0.0);
        userDAO.setImageUrl("https://tuk-planet.s3.ap-northeast-2.amazonaws.com/user/free-icon-user-149071+3.png");


        userRepositoryJPA.save(userDAO);

        return certify;
    }
}
