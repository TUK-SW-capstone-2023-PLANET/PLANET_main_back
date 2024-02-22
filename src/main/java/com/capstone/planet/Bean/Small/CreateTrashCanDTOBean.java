package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.TrashCanDAO;
import com.capstone.planet.Model.DTO.ResponseTrashCanAllGetDTO;
import com.capstone.planet.Model.DTO.ResponseTrashCanGetDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateTrashCanDTOBean {

    // trash can DTO 생성
    public ResponseTrashCanGetDTO exec(TrashCanDAO trashCanDAO){

        ResponseTrashCanGetDTO responseTrashCanGetDTO = ResponseTrashCanGetDTO.builder()
                .trashCanId(trashCanDAO.getTrashCanId())
                .location(trashCanDAO.getLatitude(), trashCanDAO.getLongitude())
                .address(trashCanDAO.getAddress())
                .imageUrl(trashCanDAO.getImageUrl())
                .build();

        return responseTrashCanGetDTO;
    }

    // trash can DTOs 생성
    public List<ResponseTrashCanAllGetDTO> exec(List<TrashCanDAO> trashCanDAOs){

        List<ResponseTrashCanAllGetDTO> responseTrashCanAllGetDTOs = new ArrayList<>();

        for (TrashCanDAO trashCanDAO : trashCanDAOs) {
            responseTrashCanAllGetDTOs.add(ResponseTrashCanAllGetDTO.builder()
                    .trashCanId(trashCanDAO.getTrashCanId())
                    .location(trashCanDAO.getLatitude(), trashCanDAO.getLongitude())
                    .build());
        }

        return responseTrashCanAllGetDTOs;
    }
}
