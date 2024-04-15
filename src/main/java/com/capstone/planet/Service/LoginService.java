package com.capstone.planet.Service;

import com.capstone.planet.Bean.LoginUserBean;
import com.capstone.planet.Model.DTO.RequestUserLoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LoginService {

    LoginUserBean loginUserBean;

    @Autowired
    public LoginService(LoginUserBean loginUserBean) {
        this.loginUserBean = loginUserBean;
    }

    // 유저 로그인
    public Map<String, Object> userLogin(RequestUserLoginDTO requestUserLoginDTO){
        return loginUserBean.exec(requestUserLoginDTO);
    }
}
