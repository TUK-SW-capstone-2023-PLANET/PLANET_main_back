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

    public Page<ResponseUniversityGetDTO> exec(String check , Page<UniversityDAO> universityDAOList){

        List<ResponseUniversityGetDTO> responseUniversityGetDTOList = new ArrayList<>();

        int i = 1;

        int pageSize = universityDAOList.getPageable().getPageSize();
        int pageNumber = universityDAOList.getPageable().getPageNumber();
        i = pageSize * pageNumber + 1;

        for(UniversityDAO universityDAO : universityDAOList){

            ResponseUniversityGetDTO responseUniversityGetDTO = new ResponseUniversityGetDTO();

            responseUniversityGetDTO.setName(universityDAO.getName());
            responseUniversityGetDTO.setImageUrl(universityDAO.getImageUrl());
            responseUniversityGetDTO.setScore(universityDAO.getScore());
            responseUniversityGetDTO.setRank(i);

            responseUniversityGetDTOList.add(responseUniversityGetDTO);
            
            i++;
        }

        return new PageImpl<>(responseUniversityGetDTOList, universityDAOList.getPageable(), universityDAOList.getTotalElements());
    }
}
