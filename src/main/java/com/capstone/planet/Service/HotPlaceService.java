package com.capstone.planet.Service;

import com.capstone.planet.Bean.GetHotPlaceBean;
import com.capstone.planet.Model.DTO.ResponseHotPlaceGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotPlaceService {

    GetHotPlaceBean getHotPlaceBean;

    @Autowired
    public HotPlaceService(GetHotPlaceBean getHotPlaceBean) {
        this.getHotPlaceBean = getHotPlaceBean;
    }

    // 핫플레이스 조회
    public List<ResponseHotPlaceGetDTO> getHotPlace(){
        return getHotPlaceBean.exec();
    }
}
