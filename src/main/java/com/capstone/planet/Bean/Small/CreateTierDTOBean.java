package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.TierDAO;
import com.capstone.planet.Model.DTO.ResponseTierGetDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateTierDTOBean {

    public ResponseTierGetDTO exec(TierDAO tierDAO){

        ResponseTierGetDTO responseTierGetDTO = new ResponseTierGetDTO();
        responseTierGetDTO.setTier(tierDAO.getTier());
        responseTierGetDTO.setImageUrl(tierDAO.getImageUrl());
        responseTierGetDTO.setContent(tierDAO.getContent());

        return responseTierGetDTO;
    }

    public List<ResponseTierGetDTO> exec(List<TierDAO> tierDAOS){

        List<ResponseTierGetDTO> responseTierGetDTOS = new ArrayList<>();

        for (TierDAO tierDAO : tierDAOS) {
            responseTierGetDTOS.add(exec(tierDAO));
        }

        return responseTierGetDTOS;
    }
}
