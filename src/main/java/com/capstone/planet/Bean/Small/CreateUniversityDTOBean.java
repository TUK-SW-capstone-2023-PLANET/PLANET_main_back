package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.UniversityDAO;
import com.capstone.planet.Model.DTO.ResponseUniversityGetDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateUniversityDTOBean {

    public ResponseUniversityGetDTO exec(UniversityDAO universityDAO){
        ResponseUniversityGetDTO responseUniversityGetDTO = new ResponseUniversityGetDTO();

        responseUniversityGetDTO.setName(universityDAO.getName());
        responseUniversityGetDTO.setImageUrl(universityDAO.getImageUrl());
        responseUniversityGetDTO.setScore(universityDAO.getScore());

        return responseUniversityGetDTO;
    }

    public List<ResponseUniversityGetDTO> exec(List<UniversityDAO> universityDAOList){

        List<ResponseUniversityGetDTO> responseUniversityGetDTOList = new ArrayList<>();

        for(UniversityDAO universityDAO : universityDAOList){
            responseUniversityGetDTOList.add(exec(universityDAO));
        }

        return responseUniversityGetDTOList;
    }
}
