package com.capstone.planet.Service;

import com.capstone.planet.Bean.GetTrashCanALLBean;
import com.capstone.planet.Bean.GetTrashCanBean;
import com.capstone.planet.Model.DTO.ResponseTrashCanAllGetDTO;
import com.capstone.planet.Model.DTO.ResponseTrashCanGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrashCanService {

    GetTrashCanBean getTrashCanBean;
    GetTrashCanALLBean getTrashCanALLBean;

    @Autowired
    public TrashCanService(GetTrashCanBean getTrashCanBean, GetTrashCanALLBean getTrashCanALLBean) {
        this.getTrashCanBean = getTrashCanBean;
        this.getTrashCanALLBean = getTrashCanALLBean;
    }

    // 쓰레기통 한 개 조회
    public ResponseTrashCanGetDTO getTrashCan(Long trashCanId){
        return getTrashCanBean.exec(trashCanId);
    }

    // 쓰레기통 전체 조회
    public List<ResponseTrashCanAllGetDTO> getTrashCanAll(){
        return getTrashCanALLBean.exec();
    }
}
