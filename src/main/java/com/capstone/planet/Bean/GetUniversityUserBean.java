package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.GetUserDAOBean;
import com.capstone.planet.Model.DAO.UserDAO;
import com.capstone.planet.Model.DTO.ResponseUserUniversityGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetUniversityUserBean {

    @Autowired
    GetUserDAOBean getUserDAOBean;

    public ResponseUserUniversityGetDTO exec(Long userId) {

        UserDAO userDAO = getUserDAOBean.exec(userId);
        if (userDAO == null) return null;

        List<UserDAO> userDAOS = getUserDAOBean.exec(userDAO.getUniversityName());

        int total = 0;
        for (UserDAO dao : userDAOS){
            total += dao.getScore();
        }

        int i = 1; // 인덱스 초기화
        for (UserDAO dao : userDAOS) {
            if (dao.equals(userDAO)) {
                // 일치하는 객체를 찾으면 해당 인덱스로 반환
                ResponseUserUniversityGetDTO responseUniversityGetDTO = new ResponseUserUniversityGetDTO();

                responseUniversityGetDTO.setNickName(dao.getNickName());
                responseUniversityGetDTO.setContribution(((double) userDAO.getScore() / total * 100));
                responseUniversityGetDTO.setScore(dao.getScore());
                responseUniversityGetDTO.setRank(i);
                return responseUniversityGetDTO;
            }
            i++; // 일치하지 않으면 인덱스 증가
        }

        return new ResponseUserUniversityGetDTO();
    }
}
