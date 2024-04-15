package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.GetUserDAOBean;
import com.capstone.planet.Model.DAO.UserDAO;
import com.capstone.planet.Model.DTO.RequestUserLoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class LoginUserBean {

    GetUserDAOBean getUserDAOBean;

    @Autowired
    public LoginUserBean(GetUserDAOBean getUserDAOBean) {
        this.getUserDAOBean = getUserDAOBean;
    }

    // 유저 로그인
    public Map<String, Object> exec(RequestUserLoginDTO requestUserLoginDTO){

        UserDAO userDAO = getUserDAOBean.exec(requestUserLoginDTO.getEmail(), "", 0L);
        if (userDAO == null) {
            return Map.of(
                    "message", "없는 이메일 입니다.",
                    "success", false
            );
        }

        if (!userDAO.getPasswd().equals(requestUserLoginDTO.getPassword())) {
            return Map.of(
                    "message", "비밀번호가 틀렸습니다.",
                    "success", false
            );
        }

        return Map.of(
                "message", "로그인 성공",
                "success", true,
                "userId", userDAO.getUserId()
        );
    }
}
