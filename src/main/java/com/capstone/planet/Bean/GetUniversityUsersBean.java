package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.CreateUniversityUserDTOBean;
import com.capstone.planet.Bean.Small.GetUserDAOBean;
import com.capstone.planet.Model.DAO.UserDAO;
import com.capstone.planet.Model.DTO.ResponseUserUniversityGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class GetUniversityUsersBean {

    GetUserDAOBean getUserDAOBean;
    CreateUniversityUserDTOBean createUniversityUserDTOBean;

    @Autowired
    public GetUniversityUsersBean(GetUserDAOBean getUserDAOBean, CreateUniversityUserDTOBean createUniversityUserDTOBean) {
        this.getUserDAOBean = getUserDAOBean;
        this.createUniversityUserDTOBean = createUniversityUserDTOBean;
    }


    // 소속 대학교 유저 점수 랭킹 조회
    public Page<ResponseUserUniversityGetDTO> exec(Long userId, Pageable pageable){

        // 유저 객체 가져오기
        UserDAO userDAO = getUserDAOBean.exec(userId);
        if (userDAO == null) return null;

        // 대학에 소속된 유저 점수 순으로 전부 가져오기
        Page<UserDAO> userDAOS = getUserDAOBean.exec(userDAO.getUniversityName(), pageable);

        int total = 0;
        for (UserDAO dao : getUserDAOBean.exec()) {
            total += dao.getScore();
        }


        // 반환 객체 만들기
        return createUniversityUserDTOBean.exec(total, userDAOS);
    }
}
