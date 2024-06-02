package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.GetUserDAOBean;
import com.capstone.planet.Model.DAO.UserDAO;
import com.capstone.planet.Model.DTO.ResponseUserUniversityGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetSearchUniversityUserBean {

    GetUserDAOBean getUserDAOBean;

    @Autowired
    public GetSearchUniversityUserBean(GetUserDAOBean getUserDAOBean) {
        this.getUserDAOBean = getUserDAOBean;
    }


    // 대학교 개인랭킹 검색 조회
    public List<ResponseUserUniversityGetDTO> exec(Long userId, String search) {

        // 유저 객체 가져오기
        UserDAO userDAO1 = getUserDAOBean.exec(userId);
        if (userDAO1 == null) return null;

        List<UserDAO> userDAOS = getUserDAOBean.exec(userDAO1.getUniversityName());

        List<ResponseUserUniversityGetDTO> responseUserUniversityGetDTOS = new ArrayList<>();

        int i = 1;

        int total = 0;
        for (UserDAO dao : getUserDAOBean.exec()) {
            total += dao.getScore();
        }


        for (UserDAO userDAO : userDAOS) {
            ResponseUserUniversityGetDTO responseUserUniversityGetDTO = new ResponseUserUniversityGetDTO();
            responseUserUniversityGetDTO.setRank(i);
            responseUserUniversityGetDTO.setNickName(userDAO.getNickName());
            responseUserUniversityGetDTO.setScore(userDAO.getScore());
            responseUserUniversityGetDTO.setContribution(((double) userDAO.getScore() / total * 100));

            responseUserUniversityGetDTOS.add(responseUserUniversityGetDTO);

            i++;
        }

        return responseUserUniversityGetDTOS.stream()
                .filter(user -> user.getNickName().contains(search))
                .collect(Collectors.toList());
    }
}
