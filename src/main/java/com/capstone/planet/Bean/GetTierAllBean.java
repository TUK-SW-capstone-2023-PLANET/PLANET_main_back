package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.CreateTierDTOBean;
import com.capstone.planet.Bean.Small.GetTierDAOBean;
import com.capstone.planet.Model.DAO.TierDAO;
import com.capstone.planet.Model.DTO.ResponseTierGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetTierAllBean {

    GetTierDAOBean getTierDAOBean;
    CreateTierDTOBean createTierDTOBean;

    @Autowired
    public GetTierAllBean(GetTierDAOBean getTierDAOBean, CreateTierDTOBean createTierDTOBean) {
        this.getTierDAOBean = getTierDAOBean;
        this.createTierDTOBean = createTierDTOBean;
    }


    // 티어 전체 조회
    public List<ResponseTierGetDTO> exec(){

        List<TierDAO> tierDAOS = getTierDAOBean.exec();

        return createTierDTOBean.exec(tierDAOS);
    }
}
