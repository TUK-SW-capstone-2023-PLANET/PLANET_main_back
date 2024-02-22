package com.capstone.planet.Service;

import com.capstone.planet.Bean.GetTrashCanBean;
import com.capstone.planet.Model.DTO.ResponseTrashCanGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrashCanService {

    GetTrashCanBean getTrashCanBean;

    @Autowired
    public TrashCanService(GetTrashCanBean getTrashCanBean) {
        this.getTrashCanBean = getTrashCanBean;
    }

    // 쓰레기통 한 개 조회
    public ResponseTrashCanGetDTO getTrashCan(Long trashCanId){
        return getTrashCanBean.exec(trashCanId);
    }
}
