package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.GetUniversityDAOBean;
import com.capstone.planet.Model.DAO.UniversityDAO;
import com.capstone.planet.Model.DTO.ResponseUniversityGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetSearchUniversityBean {

    GetUniversityDAOBean getUniversityDAOBean;

    @Autowired
    public GetSearchUniversityBean(GetUniversityDAOBean getUniversityDAOBean) {
        this.getUniversityDAOBean = getUniversityDAOBean;
    }

    // 대학교 검색 조회
    public List<ResponseUniversityGetDTO> exec(String search) {

        List<UniversityDAO> universityDAOS = getUniversityDAOBean.exec(0L);

        List<ResponseUniversityGetDTO> responseUniversityGetDTOList = new ArrayList<>();

        int i = 1;

        for(UniversityDAO universityDAO : universityDAOS){

            ResponseUniversityGetDTO responseUniversityGetDTO = new ResponseUniversityGetDTO();

            responseUniversityGetDTO.setName(universityDAO.getName());
            responseUniversityGetDTO.setImageUrl(universityDAO.getImageUrl());
            responseUniversityGetDTO.setScore(universityDAO.getScore());
            responseUniversityGetDTO.setRank(i);

            responseUniversityGetDTOList.add(responseUniversityGetDTO);

            i++;
        }

        return responseUniversityGetDTOList.stream()
                .filter(responseUniversityGetDTO -> responseUniversityGetDTO.getName().contains(search))
                .collect(Collectors.toList());
    }
}
