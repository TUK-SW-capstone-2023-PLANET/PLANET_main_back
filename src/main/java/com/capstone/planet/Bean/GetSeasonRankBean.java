package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.GetSeasonUserDAOBean;
import com.capstone.planet.Model.DAO.SeasonDAO;
import com.capstone.planet.Model.DTO.ResponseSeasonUserGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetSeasonRankBean {

    @Autowired
    GetSeasonUserDAOBean getSeasonUserDAOBean;

    public ResponseSeasonUserGetDTO exec(Long userId) {

        SeasonDAO seasonDAO = getSeasonUserDAOBean.exec(userId);
        if (seasonDAO == null) return null;

        List<SeasonDAO> seasonDAOS = getSeasonUserDAOBean.exec();

        int i = 1; // 인덱스 초기화
        for (SeasonDAO dao : seasonDAOS) {
            if (dao.equals(seasonDAO)) {
                // 일치하는 객체를 찾으면 해당 인덱스로 반환
                ResponseSeasonUserGetDTO responseSeasonUserGetDTO = new ResponseSeasonUserGetDTO();

                responseSeasonUserGetDTO.setUserName(seasonDAO.getUserName());
                responseSeasonUserGetDTO.setUniversityLogo(seasonDAO.getUniversityLogo());
                responseSeasonUserGetDTO.setScore(seasonDAO.getScore());
                responseSeasonUserGetDTO.setRank(i);

                if (i > 90) {
                    responseSeasonUserGetDTO.setTierImageUrl("https://tuk-planet.s3.ap-northeast-2.amazonaws.com/tier/image+66.png");
                    responseSeasonUserGetDTO.setTierName("bronze");
                }
                else if (i > 55) {
                    responseSeasonUserGetDTO.setTierImageUrl("https://tuk-planet.s3.ap-northeast-2.amazonaws.com/tier/image+67.png");
                    responseSeasonUserGetDTO.setTierName("silver");
                }
                else if (i > 30) {
                    responseSeasonUserGetDTO.setTierImageUrl("https://tuk-planet.s3.ap-northeast-2.amazonaws.com/tier/image+68.png");
                    responseSeasonUserGetDTO.setTierName("gold");
                }
                else if (i > 10) {
                    responseSeasonUserGetDTO.setTierImageUrl("https://tuk-planet.s3.ap-northeast-2.amazonaws.com/tier/image+69.png");
                    responseSeasonUserGetDTO.setTierName("diamond");
                }
                else if (i > 1) {
                    responseSeasonUserGetDTO.setTierImageUrl("https://tuk-planet.s3.ap-northeast-2.amazonaws.com/tier/image+70.png");
                    responseSeasonUserGetDTO.setTierName("master");
                }
                else if (i == 1) {
                    responseSeasonUserGetDTO.setTierImageUrl("https://tuk-planet.s3.ap-northeast-2.amazonaws.com/tier/image+71.png");
                    responseSeasonUserGetDTO.setTierName("challenger");
                }
                else {
                    responseSeasonUserGetDTO.setTierImageUrl(null);
                    responseSeasonUserGetDTO.setTierName(null);
                }

                return responseSeasonUserGetDTO;
            }
            i++; // 일치하지 않으면 인덱스 증가
        }

        return null;
    }
}
