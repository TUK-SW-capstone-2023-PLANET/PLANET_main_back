package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.UniversityDAO;
import com.capstone.planet.Model.DTO.ResponseUniversityGetDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    public List<Map<Integer, ResponseUniversityGetDTO>> exec(String check , List<UniversityDAO> universityDAOList){

        List<Map<Integer, ResponseUniversityGetDTO>> responseUniversityGetDTOList = new ArrayList<>();

        int i = 1;
        for(UniversityDAO universityDAO : universityDAOList){
            ResponseUniversityGetDTO responseUniversityGetDTO = exec(universityDAO);

            Map map = Map.of(i, responseUniversityGetDTO);
            i++;
            responseUniversityGetDTOList.add(map);
        }

        return responseUniversityGetDTOList;
    }
}
