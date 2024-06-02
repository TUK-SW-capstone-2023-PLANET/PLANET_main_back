package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.GetSeasonUserDAOBean;
import com.capstone.planet.Model.DAO.SeasonDAO;
import com.capstone.planet.Model.DTO.ResponseSeasonUserGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetSearchSeasonBean {

    GetSeasonUserDAOBean getSeasonUserDAOBean;

    @Autowired
    public GetSearchSeasonBean(GetSeasonUserDAOBean getSeasonUserDAOBean) {
        this.getSeasonUserDAOBean = getSeasonUserDAOBean;
    }

    // 시즌 랭킹 검색 조회
    public List<ResponseSeasonUserGetDTO> exec(String search) {

        List<SeasonDAO> seasonDAOS = getSeasonUserDAOBean.exec();

        List<ResponseSeasonUserGetDTO> responseList = new ArrayList<>();

        int i = 1;

        for (SeasonDAO seasonDAO : seasonDAOS) {
            ResponseSeasonUserGetDTO responseSeasonUserGetDTO = new ResponseSeasonUserGetDTO();
            responseSeasonUserGetDTO.setUserName(seasonDAO.getUserName());
            responseSeasonUserGetDTO.setRank(i);
            responseSeasonUserGetDTO.setScore(seasonDAO.getScore());
            responseSeasonUserGetDTO.setUniversityLogo(seasonDAO.getUniversityLogo());

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
            responseList.add(responseSeasonUserGetDTO);
            i++;
        }

        return responseList.stream()
                .filter(responseSeasonUserGetDTO -> responseSeasonUserGetDTO.getUserName().contains(search))
                .collect(Collectors.toList());
    }
}
