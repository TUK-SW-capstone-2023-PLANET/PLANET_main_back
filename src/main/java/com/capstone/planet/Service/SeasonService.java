package com.capstone.planet.Service;

import com.capstone.planet.Bean.GetSeasonUserBean;
import com.capstone.planet.Model.DTO.ResponseSeasonUserGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SeasonService {
    GetSeasonUserBean getSeasonUserBean;

    @Autowired
    public SeasonService(GetSeasonUserBean getSeasonUserBean) {
        this.getSeasonUserBean = getSeasonUserBean;
    }

    public List<Map<Integer, ResponseSeasonUserGetDTO>> getSeasonUsers(Long userId) {
        return getSeasonUserBean.exec(userId);
    }

}
