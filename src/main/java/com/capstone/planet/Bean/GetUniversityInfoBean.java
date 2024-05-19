package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.GetUserDAOBean;
import com.capstone.planet.Model.DAO.UserDAO;
import com.capstone.planet.Model.DTO.ResponseUniversityInfoGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetUniversityInfoBean {

    @Autowired
    GetUserDAOBean getUserDAOBean;

    // 대학교 정보 조회
    public ResponseUniversityInfoGetDTO exec(Long userId) {

        UserDAO userDAO = getUserDAOBean.exec(userId);

        return ResponseUniversityInfoGetDTO.builder()
                .userId(userDAO.getUserId())
                .universityName(userDAO.getUniversityName())
                .universityLogo(userDAO.getUniversityLogo())
                .build();
    }
}
