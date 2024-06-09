package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.CreateUniqueIdBean;
import com.capstone.planet.Bean.Small.GetAddressBean;
import com.capstone.planet.Bean.Small.SaveTrashCanDAOBean;
import com.capstone.planet.Model.DAO.TrashCanDAO;
import com.capstone.planet.Model.DTO.RequestTrashCanSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveTrashCanBean {

    CreateUniqueIdBean createUniqueIdBean;
    GetAddressBean getAddressBean;
    SaveTrashCanDAOBean saveTrashCanDAOBean;

    @Autowired
    public SaveTrashCanBean(CreateUniqueIdBean createUniqueIdBean, GetAddressBean getAddressBean, SaveTrashCanDAOBean saveTrashCanDAOBean) {
        this.createUniqueIdBean = createUniqueIdBean;
        this.getAddressBean = getAddressBean;
        this.saveTrashCanDAOBean = saveTrashCanDAOBean;
    }

    // 쓰레기통 저장
    public Long exec(RequestTrashCanSaveDTO requestTrashCanSaveDTO){

        TrashCanDAO trashCanDAO = TrashCanDAO.builder()
                .trashCanId(createUniqueIdBean.exec())
                .userId(requestTrashCanSaveDTO.getUserId())
                .latitude(requestTrashCanSaveDTO.getLatitude())
                .longitude(requestTrashCanSaveDTO.getLongitude())
                .address(getAddressBean.exec(requestTrashCanSaveDTO.getLongitude(), requestTrashCanSaveDTO.getLatitude()))
                .imageUrl(requestTrashCanSaveDTO.getImageUrl())
                .build();

        saveTrashCanDAOBean.exec(trashCanDAO);

        return trashCanDAO.getTrashCanId();
    }
}
