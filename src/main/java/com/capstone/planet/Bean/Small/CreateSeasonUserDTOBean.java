package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.SeasonDAO;
import com.capstone.planet.Model.DAO.UserDAO;
import com.capstone.planet.Model.DTO.ResponseSeasonUserGetDTO;
import com.capstone.planet.Model.DTO.ResponseUserUniversityGetDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CreateSeasonUserDTOBean {

    public List<ResponseSeasonUserGetDTO> exec(List<SeasonDAO> seasonDAOS){

        List<ResponseSeasonUserGetDTO> responseList = new ArrayList<>();

        int i = 1;
        for (SeasonDAO seasonDAO : seasonDAOS) {
            ResponseSeasonUserGetDTO responseSeasonUserGetDTO = new ResponseSeasonUserGetDTO();
            responseSeasonUserGetDTO.setUserName(seasonDAO.getUserName());
            responseSeasonUserGetDTO.setScore(seasonDAO.getScore());

            if (i>1) {
                responseSeasonUserGetDTO.setTierImageUrl("https://tuk-planet.s3.ap-northeast-2.amazonaws.com/tier/image+70.png");
                responseSeasonUserGetDTO.setTierName("master");
            }
            else if (i==1) {
                responseSeasonUserGetDTO.setTierImageUrl("https://tuk-planet.s3.ap-northeast-2.amazonaws.com/tier/image+71.png");
                responseSeasonUserGetDTO.setTierName("challenger");
            }

            responseList.add(responseSeasonUserGetDTO);
            i++;
        }


        return responseList;
    }

    public Page<ResponseSeasonUserGetDTO> exec(Page<SeasonDAO> seasonDAOS) {
        List<ResponseSeasonUserGetDTO> responseList = new ArrayList<>();

        int pageSize = seasonDAOS.getSize();
        int pageNumber = seasonDAOS.getNumber();

        int i = pageNumber*pageSize + 1;

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

        // PageRequest.of() 메서드를 사용하여 페이지 정보를 생성하고 Page 객체로 반환
        return new PageImpl<>(responseList, seasonDAOS.getPageable(), responseList.size());
    }

    public List<Map<Integer, ResponseSeasonUserGetDTO>> exec(String check, UserDAO userDAO, List<SeasonDAO> seasonDAOS){

        List<Map<Integer, ResponseSeasonUserGetDTO>> responseList = new ArrayList<>();
        Map<Integer, ResponseSeasonUserGetDTO> map = new HashMap<>();

        int i = 1;
        for (SeasonDAO seasonDAO : seasonDAOS) {

            ResponseSeasonUserGetDTO responseSeasonUserGetDTO = new ResponseSeasonUserGetDTO();

            if (i>5){
                if (seasonDAO.getUserId().equals(userDAO.getUserId())){
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
                    else {
                        responseSeasonUserGetDTO.setTierImageUrl("https://tuk-planet.s3.ap-northeast-2.amazonaws.com/tier/image+70.png");
                        responseSeasonUserGetDTO.setTierName("master");
                    }

                    map.put(0, responseSeasonUserGetDTO);
                }
                i++;
                continue;
            }
            responseSeasonUserGetDTO.setUserName(seasonDAO.getUserName());
            responseSeasonUserGetDTO.setRank(i);
            responseSeasonUserGetDTO.setScore(seasonDAO.getScore());
            responseSeasonUserGetDTO.setUniversityLogo(seasonDAO.getUniversityLogo());

            if (i>1) {
                responseSeasonUserGetDTO.setTierImageUrl("https://tuk-planet.s3.ap-northeast-2.amazonaws.com/tier/image+70.png");
                responseSeasonUserGetDTO.setTierName("master");
            }
            else if (i==1) {
                responseSeasonUserGetDTO.setTierImageUrl("https://tuk-planet.s3.ap-northeast-2.amazonaws.com/tier/image+71.png");
                responseSeasonUserGetDTO.setTierName("challenger");
            }
            else {
                responseSeasonUserGetDTO.setTierImageUrl(null);
                responseSeasonUserGetDTO.setTierName(null);
            }

            if (seasonDAO.getUserId().equals(userDAO.getUserId()))
                map.put(0, responseSeasonUserGetDTO);

            map.put(responseSeasonUserGetDTO.getRank(), responseSeasonUserGetDTO);
            i++;
        }

        responseList.add(map);

        return responseList;
    }
}
