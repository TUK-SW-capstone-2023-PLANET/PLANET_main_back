package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.*;
import com.capstone.planet.Model.DAO.PloggingDAO;
import com.capstone.planet.Model.DTO.LocationDTO;
import com.capstone.planet.Model.DTO.ResponsePloggingGetDTO;
import com.capstone.planet.Model.DTO.TrashDTO;
import com.capstone.planet.Model.DTO.TrashInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class GetPloggingBean {

    GetPloggingDAOBean getPloggingDAOBean;
    GetPloggingLocationDAOBean getPloggingLocationDAOBean;
    GetPloggingTrashDAOBean getPloggingTrashDAOBean;
    GetPloggingTrashInfoDAOBean getPloggingTrashInfoDAOBean;
    CreatePloggingDTOBean createPloggingDTOBean;

    @Autowired
    public GetPloggingBean(GetPloggingDAOBean getPloggingDAOBean, GetPloggingLocationDAOBean getPloggingLocationDAOBean, GetPloggingTrashDAOBean getPloggingTrashDAOBean, GetPloggingTrashInfoDAOBean getPloggingTrashInfoDAOBean, CreatePloggingDTOBean createPloggingDTOBean) {
        this.getPloggingDAOBean = getPloggingDAOBean;
        this.getPloggingLocationDAOBean = getPloggingLocationDAOBean;
        this.getPloggingTrashDAOBean = getPloggingTrashDAOBean;
        this.getPloggingTrashInfoDAOBean = getPloggingTrashInfoDAOBean;
        this.createPloggingDTOBean = createPloggingDTOBean;
    }

    public ResponsePloggingGetDTO exec(Long ploggingId){

        // 플로깅 객체 가져오기
        PloggingDAO ploggingDAO = getPloggingDAOBean.exec(ploggingId);
        if (ploggingDAO == null) return null;

        // 위치 가공
        List<LocationDTO> locationDTOS = getPloggingLocationDAOBean.exec(ploggingDAO.getLocation());

        // 쓰레기 가공
        List<TrashDTO> trashDTOS = getPloggingTrashDAOBean.exec(ploggingDAO.getTrash());

        // 쓰레기 영수증 가공
        List<Map<String, List<TrashInfoDTO>>> mapList = getPloggingTrashInfoDAOBean.exec(ploggingId);

        // DTO 생성
        return createPloggingDTOBean.exec(ploggingDAO, locationDTOS, trashDTOS, mapList);
    }
}
