package com.capstone.planet.Service;

import com.capstone.planet.Bean.GetSeasonTop3Bean;
import com.capstone.planet.Bean.GetSeasonUserBean;
import com.capstone.planet.Model.DTO.ResponseSeasonUserGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SeasonService {

    GetSeasonTop3Bean getSeasonTop3Bean;
    GetSeasonUserBean getSeasonUserBean;

    @Autowired
    public SeasonService(GetSeasonTop3Bean getSeasonTop3Bean, GetSeasonUserBean getSeasonUserBean) {
        this.getSeasonTop3Bean = getSeasonTop3Bean;
        this.getSeasonUserBean = getSeasonUserBean;
    }

    public List<ResponseSeasonUserGetDTO> getSeasonTop3() {
        return getSeasonTop3Bean.exec();
    }

    public List<Map<Integer, ResponseSeasonUserGetDTO>> getSeasonUsers(Long userId) {
        return getSeasonUserBean.exec(userId);
    }

}
