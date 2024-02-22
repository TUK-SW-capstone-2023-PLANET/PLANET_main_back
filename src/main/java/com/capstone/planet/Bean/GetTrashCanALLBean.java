package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.CreateTrashCanDTOBean;
import com.capstone.planet.Bean.Small.GetTrashCanDAOBean;
import com.capstone.planet.Model.DAO.TrashCanDAO;
import com.capstone.planet.Model.DTO.ResponseTrashCanAllGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetTrashCanALLBean {

    GetTrashCanDAOBean getTrashCanDAOBean;
    CreateTrashCanDTOBean createTrashCanDTOBean;

    @Autowired
    public GetTrashCanALLBean(GetTrashCanDAOBean getTrashCanDAOBean, CreateTrashCanDTOBean createTrashCanDTOBean) {
        this.getTrashCanDAOBean = getTrashCanDAOBean;
        this.createTrashCanDTOBean = createTrashCanDTOBean;
    }

    // 쓰레기통 전체 조회
    public List<ResponseTrashCanAllGetDTO> exec(){

        // 쓰레기통 전부 가져오기
        List<TrashCanDAO> trashCanDAOs = getTrashCanDAOBean.exec();

        // DTO 로 변환해서 리턴
        return createTrashCanDTOBean.exec(trashCanDAOs);
    }
}
