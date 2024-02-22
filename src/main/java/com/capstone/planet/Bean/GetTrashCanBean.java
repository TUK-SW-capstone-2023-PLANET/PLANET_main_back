package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.CreateTrashCanDTOBean;
import com.capstone.planet.Bean.Small.GetTrashCanDAOBean;
import com.capstone.planet.Model.DAO.TrashCanDAO;
import com.capstone.planet.Model.DTO.ResponseTrashCanGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetTrashCanBean {

    GetTrashCanDAOBean getTrashCanDAOBean;
    CreateTrashCanDTOBean createTrashCanDTOBean;

    @Autowired
    public GetTrashCanBean(GetTrashCanDAOBean getTrashCanDAOBean, CreateTrashCanDTOBean createTrashCanDTOBean) {
        this.getTrashCanDAOBean = getTrashCanDAOBean;
        this.createTrashCanDTOBean = createTrashCanDTOBean;
    }

    // 쓰레기통 정보 가져오기
    public ResponseTrashCanGetDTO exec(Long trashCanId){

        // trashCanDAO 객체 가져오기
        TrashCanDAO trashCanDAO = getTrashCanDAOBean.exec(trashCanId);
        if (trashCanDAO == null) return null;

        // DTO 로 변환해서 리턴
        return createTrashCanDTOBean.exec(trashCanDAO);
    }
}
