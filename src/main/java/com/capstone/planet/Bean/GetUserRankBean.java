package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.GetUserDAOBean;
import com.capstone.planet.Model.DAO.UserDAO;
import com.capstone.planet.Model.DTO.ResponseUserRanksGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetUserRankBean {

    @Autowired
    GetUserDAOBean getUserDAOBean;

    public ResponseUserRanksGetDTO exec(Long userId) {

        UserDAO userDAO = getUserDAOBean.exec(userId);
        if (userDAO == null) return null;

        List<UserDAO> userDAOS = getUserDAOBean.exec();


        int i = 1; // 인덱스 초기화
        for (UserDAO dao : userDAOS) {
            if (dao.equals(userDAO)) {
                // 일치하는 객체를 찾으면 해당 인덱스로 반환
                ResponseUserRanksGetDTO responseUserRanksGetDTO = new ResponseUserRanksGetDTO();

                responseUserRanksGetDTO.setNickName(dao.getNickName());
                responseUserRanksGetDTO.setImageUrl(dao.getImageUrl());
                responseUserRanksGetDTO.setScore(dao.getScore());
                responseUserRanksGetDTO.setRank(i);
                responseUserRanksGetDTO.setUniversityLogo(dao.getUniversityLogo());

                return responseUserRanksGetDTO;
            }
            i++; // 일치하지 않으면 인덱스 증가
        }

        return null;
    }
}
