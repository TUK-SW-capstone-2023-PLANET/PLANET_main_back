package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.UniversityDAO;
import com.capstone.planet.Model.DTO.ResponseUniversityGetDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
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

    public Page<Map<Integer, ResponseUniversityGetDTO>> exec(String check , Page<UniversityDAO> universityDAOList){

        List<Map<Integer, ResponseUniversityGetDTO>> responseUniversityGetDTOList = new ArrayList<>();

        int i = 1;
        for(UniversityDAO universityDAO : universityDAOList){
            ResponseUniversityGetDTO responseUniversityGetDTO = new ResponseUniversityGetDTO();

            responseUniversityGetDTO.setName(universityDAO.getName());
            responseUniversityGetDTO.setImageUrl(universityDAO.getImageUrl());
            responseUniversityGetDTO.setScore(universityDAO.getScore());
            responseUniversityGetDTO.setRank(i);

            Map<Integer, ResponseUniversityGetDTO> map = Map.of(i, responseUniversityGetDTO);
            responseUniversityGetDTOList.add(map);
            
            i++;
        }

        return new PageImpl<>(responseUniversityGetDTOList, universityDAOList.getPageable(), universityDAOList.getTotalElements());
    }
}
