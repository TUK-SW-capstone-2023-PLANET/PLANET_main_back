package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.TrashCanDAO;
import com.capstone.planet.Model.DTO.ResponseTrashCanGetDTO;
import org.springframework.stereotype.Component;

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
}
