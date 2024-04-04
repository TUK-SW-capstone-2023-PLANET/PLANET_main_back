package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.CreateUserDTOBean;
import com.capstone.planet.Bean.Small.GetUserDAOBean;
import com.capstone.planet.Model.DAO.UniversityDAO;
import com.capstone.planet.Model.DAO.UserDAO;
import com.capstone.planet.Model.DTO.ResponseUniversityGetDTO;
import com.capstone.planet.Model.DTO.ResponseUserRankGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetUserTop3Bean {

    GetUserDAOBean getUserDAOBean;
    CreateUserDTOBean createUserDTOBean;

    @Autowired
    public GetUserTop3Bean(GetUserDAOBean getUserDAOBean, CreateUserDTOBean createUserDTOBean) {
        this.getUserDAOBean = getUserDAOBean;
        this.createUserDTOBean = createUserDTOBean;
    }

    // 점수 높은 대학 3개 조회
    public List<ResponseUserRankGetDTO> exec(){

        List<UserDAO> userDAOS = getUserDAOBean.exec("check1", "check2");

        return createUserDTOBean.exec(userDAOS);
    }
}
