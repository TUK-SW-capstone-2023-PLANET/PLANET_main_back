package com.capstone.planet.Service;

import com.capstone.planet.Bean.GetSeasonRankBean;
import com.capstone.planet.Bean.GetSeasonTop3Bean;
import com.capstone.planet.Bean.GetSeasonUser5Bean;
import com.capstone.planet.Bean.GetSeasonUserBean;
import com.capstone.planet.Model.DTO.ResponseSeasonUserGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SeasonService {

    GetSeasonRankBean getSeasonRankBean;
    GetSeasonUserBean getSeasonUserBean;
    GetSeasonUser5Bean getSeasonUser5Bean;

    @Autowired
    public SeasonService(GetSeasonRankBean getSeasonRankBean, GetSeasonUserBean getSeasonUserBean, GetSeasonUser5Bean getSeasonUser5Bean) {
        this.getSeasonRankBean = getSeasonRankBean;
        this.getSeasonUserBean = getSeasonUserBean;
        this.getSeasonUser5Bean = getSeasonUser5Bean;
    }

    public ResponseSeasonUserGetDTO getSeason(Long userId) {
        return getSeasonRankBean.exec(userId);
    }

    public Page<ResponseSeasonUserGetDTO> getSeasonUsers(Pageable pageable) {
        return getSeasonUserBean.exec(pageable);
    }

    public List<Map<Integer, ResponseSeasonUserGetDTO>> getSeason5Users(Long userId) {
        return getSeasonUser5Bean.exec(userId);
    }

}
