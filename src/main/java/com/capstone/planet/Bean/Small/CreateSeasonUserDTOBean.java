package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.SeasonDAO;
import com.capstone.planet.Model.DAO.UserDAO;
import com.capstone.planet.Model.DTO.ResponseSeasonUserGetDTO;
import com.capstone.planet.Model.DTO.ResponseUserUniversityGetDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CreateSeasonUserDTOBean {

    public List<Map<Integer, ResponseSeasonUserGetDTO>> exec(UserDAO userDAO, List<SeasonDAO> seasonDAOS){

        List<Map<Integer, ResponseSeasonUserGetDTO>> responseList = new ArrayList<>();
        Map<Integer, ResponseSeasonUserGetDTO> map = new HashMap<>();

        int i = 1;
        for (SeasonDAO seasonDAO : seasonDAOS) {
            ResponseSeasonUserGetDTO responseSeasonUserGetDTO = new ResponseSeasonUserGetDTO();
            responseSeasonUserGetDTO.setUserName(seasonDAO.getUserName());
            responseSeasonUserGetDTO.setRank(i);
            responseSeasonUserGetDTO.setScore(seasonDAO.getScore());
            responseSeasonUserGetDTO.setUniversityLogo(seasonDAO.getUniversityLogo());

            if (i >90) responseSeasonUserGetDTO.setTierImageUrl("https://tuk-planet.s3.ap-northeast-2.amazonaws.com/tier/image+66.png");
            else if (i>55) responseSeasonUserGetDTO.setTierImageUrl("https://tuk-planet.s3.ap-northeast-2.amazonaws.com/tier/image+67.png");
            else if (i>30) responseSeasonUserGetDTO.setTierImageUrl("https://tuk-planet.s3.ap-northeast-2.amazonaws.com/tier/image+68.png");
            else if (i>10) responseSeasonUserGetDTO.setTierImageUrl("https://tuk-planet.s3.ap-northeast-2.amazonaws.com/tier/image+69.png");
            else if (i>1) responseSeasonUserGetDTO.setTierImageUrl("https://tuk-planet.s3.ap-northeast-2.amazonaws.com/tier/image+70.png");
            else if (i==1) responseSeasonUserGetDTO.setTierImageUrl("https://tuk-planet.s3.ap-northeast-2.amazonaws.com/tier/image+71.png");
            else responseSeasonUserGetDTO.setTierImageUrl(null);


            if (seasonDAO.getUserId().equals(userDAO.getUserId()))
                map.put(0, responseSeasonUserGetDTO);

            map.put(responseSeasonUserGetDTO.getRank(), responseSeasonUserGetDTO);
            i++;
        }

        responseList.add(map);

        return responseList;
    }
}
