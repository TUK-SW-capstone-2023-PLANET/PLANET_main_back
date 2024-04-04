package com.capstone.planet.Service;

import com.capstone.planet.Bean.GetSeasonTop3Bean;
import com.capstone.planet.Bean.GetSeasonUser5Bean;
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
    GetSeasonUser5Bean getSeasonUser5Bean;

    @Autowired
    public SeasonService(GetSeasonTop3Bean getSeasonTop3Bean, GetSeasonUserBean getSeasonUserBean, GetSeasonUser5Bean getSeasonUser5Bean) {
        this.getSeasonTop3Bean = getSeasonTop3Bean;
        this.getSeasonUserBean = getSeasonUserBean;
        this.getSeasonUser5Bean = getSeasonUser5Bean;
    }

    public List<ResponseSeasonUserGetDTO> getSeasonTop3() {
        return getSeasonTop3Bean.exec();
    }

    public List<Map<Integer, ResponseSeasonUserGetDTO>> getSeasonUsers(Long userId) {
        return getSeasonUserBean.exec(userId);
    }

    public List<Map<Integer, ResponseSeasonUserGetDTO>> getSeason5Users(Long userId) {
        return getSeasonUser5Bean.exec(userId);
    }

}
