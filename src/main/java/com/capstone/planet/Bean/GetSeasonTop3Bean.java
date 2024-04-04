package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.CreateSeasonUserDTOBean;
import com.capstone.planet.Bean.Small.GetSeasonUserDAOBean;
import com.capstone.planet.Model.DAO.SeasonDAO;
import com.capstone.planet.Model.DTO.ResponseSeasonUserGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetSeasonTop3Bean {

    GetSeasonUserDAOBean getSeasonUserDAOBean;
    CreateSeasonUserDTOBean createSeasonUserDTOBean;

    @Autowired
    public GetSeasonTop3Bean(GetSeasonUserDAOBean getSeasonUserDAOBean, CreateSeasonUserDTOBean createSeasonUserDTOBean) {
        this.getSeasonUserDAOBean = getSeasonUserDAOBean;
        this.createSeasonUserDTOBean = createSeasonUserDTOBean;
    }

    // 시즌 유저 점수 랭킹 조회
    public List<ResponseSeasonUserGetDTO> exec() {

        // 시즌에 소속된 유저 점수 순으로 전부 가져오기
        List<SeasonDAO> seasonDAOS = getSeasonUserDAOBean.exec("check");

        return createSeasonUserDTOBean.exec(seasonDAOS);
    }
}
