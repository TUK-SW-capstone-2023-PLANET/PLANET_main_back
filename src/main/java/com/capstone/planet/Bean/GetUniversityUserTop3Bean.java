package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.CreateUniversityUserDTOBean;
import com.capstone.planet.Bean.Small.GetUserDAOBean;
import com.capstone.planet.Model.DAO.UserDAO;
import com.capstone.planet.Model.DTO.ResponseUserUniversityTop3GetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetUniversityUserTop3Bean {

    GetUserDAOBean getUserDAOBean;
    CreateUniversityUserDTOBean createUniversityUserDTOBean;

    @Autowired
    public GetUniversityUserTop3Bean(GetUserDAOBean getUserDAOBean, CreateUniversityUserDTOBean createUniversityUserDTOBean) {
        this.getUserDAOBean = getUserDAOBean;
        this.createUniversityUserDTOBean = createUniversityUserDTOBean;
    }

    // 소속 대학교 유저 점수 랭킹 탑 3 조회
    public List<ResponseUserUniversityTop3GetDTO> exec(Long userId){

        // 유저 객체 가져오기
        UserDAO userDAO = getUserDAOBean.exec(userId);
        if (userDAO == null) return null;

        // 대학에 소속된 유저 점수 순으로 전부 가져오기
        List<UserDAO> userDAOS = getUserDAOBean.exec(userDAO.getUniversityName());

        // 반환 객체 만들기
        return createUniversityUserDTOBean.exec(userDAOS);
    }
}
