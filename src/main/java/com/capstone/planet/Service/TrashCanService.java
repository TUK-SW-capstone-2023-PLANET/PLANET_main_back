package com.capstone.planet.Service;

import com.capstone.planet.Bean.GetTrashCanALLBean;
import com.capstone.planet.Bean.GetTrashCanBean;
import com.capstone.planet.Bean.SaveTrashCanBean;
import com.capstone.planet.Model.DTO.RequestTrashCanSaveDTO;
import com.capstone.planet.Model.DTO.ResponseTrashCanAllGetDTO;
import com.capstone.planet.Model.DTO.ResponseTrashCanGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrashCanService {

    GetTrashCanBean getTrashCanBean;
    GetTrashCanALLBean getTrashCanALLBean;
    SaveTrashCanBean saveTrashCanBean;

    @Autowired
    public TrashCanService(GetTrashCanBean getTrashCanBean, GetTrashCanALLBean getTrashCanALLBean, SaveTrashCanBean saveTrashCanBean) {
        this.getTrashCanBean = getTrashCanBean;
        this.getTrashCanALLBean = getTrashCanALLBean;
        this.saveTrashCanBean = saveTrashCanBean;
    }

    // 쓰레기통 한 개 조회
    public ResponseTrashCanGetDTO getTrashCan(Long trashCanId){
        return getTrashCanBean.exec(trashCanId);
    }

    // 쓰레기통 전체 조회
    public List<ResponseTrashCanAllGetDTO> getTrashCanAll(){
        return getTrashCanALLBean.exec();
    }

    // 쓰레기통 저장
    public Long saveTrashCan(RequestTrashCanSaveDTO requestTrashCanSaveDTO){
        return saveTrashCanBean.exec(requestTrashCanSaveDTO);
    }
}
