package com.capstone.planet.Service;

import com.capstone.planet.Bean.GetTierAllBean;
import com.capstone.planet.Model.DTO.ResponseTierGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TierService {

    GetTierAllBean getTierAllBean;

    @Autowired
    public TierService(GetTierAllBean getTierAllBean) {
        this.getTierAllBean = getTierAllBean;
    }

    public List<ResponseTierGetDTO> getTiers() {
        return getTierAllBean.exec();
    }
}
