package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.GetUserDAOBean;
import com.capstone.planet.Model.DAO.UserDAO;
import com.capstone.planet.Model.DTO.ResponseUserRanksGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetSearchPloggingBean {

    GetUserDAOBean getUserDAOBean;

    @Autowired
    public GetSearchPloggingBean(GetUserDAOBean getUserDAOBean) {
        this.getUserDAOBean = getUserDAOBean;
    }

    // 플로깅 랭킹 검색
    public List<ResponseUserRanksGetDTO> exec(String search) {

        List<UserDAO> userDAOS = getUserDAOBean.exec();

        List<ResponseUserRanksGetDTO> responseList = new ArrayList<>();
        int i = 1;


        for (UserDAO userDAO : userDAOS) {
            ResponseUserRanksGetDTO responseUserRanksGetDTO = new ResponseUserRanksGetDTO();
            responseUserRanksGetDTO.setNickName(userDAO.getNickName());
            responseUserRanksGetDTO.setRank(i);
            responseUserRanksGetDTO.setScore(userDAO.getScore());
            responseUserRanksGetDTO.setUniversityLogo(userDAO.getUniversityLogo());

            responseList.add(responseUserRanksGetDTO);
            i++;
        }

        return responseList.stream()
                .filter(responseUserRanksGetDTO -> responseUserRanksGetDTO.getNickName().contains(search))
                .collect(Collectors.toList());
    }
}
