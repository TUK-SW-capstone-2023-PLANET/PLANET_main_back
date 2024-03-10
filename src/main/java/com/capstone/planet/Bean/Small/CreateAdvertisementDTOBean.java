package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.AdvertisementDAO;
import com.capstone.planet.Model.DTO.ResponseAdvertisementGetDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateAdvertisementDTOBean {

    public ResponseAdvertisementGetDTO exec(AdvertisementDAO advertisementDAO){
        ResponseAdvertisementGetDTO responseAdvertisementGetDTO = new ResponseAdvertisementGetDTO();

        responseAdvertisementGetDTO.setAdvertisementId(advertisementDAO.getAdvertisementId());
        responseAdvertisementGetDTO.setImageUrl(advertisementDAO.getImageUrl());
        responseAdvertisementGetDTO.setLinkUrl(advertisementDAO.getLinkUrl());

        return responseAdvertisementGetDTO;
    }

    public List<ResponseAdvertisementGetDTO> exec(List<AdvertisementDAO> advertisementDAOList){

        List<ResponseAdvertisementGetDTO> responseAdvertisementGetDTOList = new ArrayList<>();

        for(AdvertisementDAO advertisementDAO : advertisementDAOList){
            responseAdvertisementGetDTOList.add(exec(advertisementDAO));
        }

        return responseAdvertisementGetDTOList;
    }
}
