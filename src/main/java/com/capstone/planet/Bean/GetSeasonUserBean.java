package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.CreateSeasonUserDTOBean;
import com.capstone.planet.Bean.Small.GetSeasonUserDAOBean;
import com.capstone.planet.Bean.Small.GetUserDAOBean;
import com.capstone.planet.Model.DAO.SeasonDAO;
import com.capstone.planet.Model.DAO.UserDAO;
import com.capstone.planet.Model.DTO.ResponseSeasonUserGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class GetSeasonUserBean {

    GetSeasonUserDAOBean getSeasonUserDAOBean;
    CreateSeasonUserDTOBean createSeasonUserDTOBean;

    @Autowired
    public GetSeasonUserBean(GetSeasonUserDAOBean getSeasonUserDAOBean, CreateSeasonUserDTOBean createSeasonUserDTOBean) {
        this.getSeasonUserDAOBean = getSeasonUserDAOBean;
        this.createSeasonUserDTOBean = createSeasonUserDTOBean;
    }

    // 시즌 유저 점수 랭킹 조회
    public Page<ResponseSeasonUserGetDTO> exec(Pageable pageable) {

        // 시즌에 소속된 유저 점수 순으로 전부 가져오기
        Page<SeasonDAO> seasonDAOS = getSeasonUserDAOBean.exec(pageable);

        return createSeasonUserDTOBean.exec(seasonDAOS);
    }
}
