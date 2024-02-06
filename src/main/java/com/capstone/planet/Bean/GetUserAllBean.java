package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.CreateUserDTOBean;
import com.capstone.planet.Bean.Small.GetUserDAOBean;
import com.capstone.planet.Model.DTO.ResponseUserAllGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetUserAllBean {

    GetUserDAOBean getUserDAOBean;
    CreateUserDTOBean createUserDTOBean;

    @Autowired
    public GetUserAllBean(GetUserDAOBean getUserDAOBean, CreateUserDTOBean createUserDTOBean) {
        this.getUserDAOBean = getUserDAOBean;
        this.createUserDTOBean = createUserDTOBean;
    }

    // 전체 유저 정보 가져오기
    public ResponseUserAllGetDTO exec(){

        // 전체 유저 정보 가져오기
        return getUserDAOBean.exec();
/*
        // 유저 정보 DTO 생성 및 반환
        return createUserDTOBean.exec(userAllInfo);*/
    }
}
