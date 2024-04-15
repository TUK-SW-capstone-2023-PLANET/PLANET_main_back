package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.GetUserDAOBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckUserNameBean {

    @Autowired
    GetUserDAOBean getUserDAOBean;

    // 유저 이름 중복 체크
    public boolean exec(String nickName){

        return !getUserDAOBean.exec(nickName, 0L);
    }
}
