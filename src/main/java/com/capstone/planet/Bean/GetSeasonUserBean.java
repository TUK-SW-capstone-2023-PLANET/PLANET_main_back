package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.CreateSeasonUserDTOBean;
import com.capstone.planet.Bean.Small.GetSeasonUserDAOBean;
import com.capstone.planet.Bean.Small.GetUserDAOBean;
import com.capstone.planet.Model.DAO.SeasonDAO;
import com.capstone.planet.Model.DAO.UserDAO;
import com.capstone.planet.Model.DTO.ResponseSeasonUserGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class GetSeasonUserBean {

    GetUserDAOBean getUserDAOBean;
    GetSeasonUserDAOBean getSeasonUserDAOBean;
    CreateSeasonUserDTOBean createSeasonUserDTOBean;

    @Autowired
    public GetSeasonUserBean(GetUserDAOBean getUserDAOBean, GetSeasonUserDAOBean getSeasonUserDAOBean, CreateSeasonUserDTOBean createSeasonUserDTOBean) {
        this.getUserDAOBean = getUserDAOBean;
        this.getSeasonUserDAOBean = getSeasonUserDAOBean;
        this.createSeasonUserDTOBean = createSeasonUserDTOBean;
    }

    // 시즌 유저 점수 랭킹 조회
    public List<Map<Integer, ResponseSeasonUserGetDTO>> exec(Long userId) {

        // 유저 객체 가져오기
        UserDAO userDAO = getUserDAOBean.exec(userId);
        if (userDAO == null) return null;

        // 시즌에 소속된 유저 점수 순으로 전부 가져오기
        List<SeasonDAO> seasonDAOS = getSeasonUserDAOBean.exec();

        return createSeasonUserDTOBean.exec(userDAO, seasonDAOS);
    }
}
