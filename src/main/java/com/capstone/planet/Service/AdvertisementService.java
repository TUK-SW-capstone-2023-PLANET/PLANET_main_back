package com.capstone.planet.Service;

import com.capstone.planet.Bean.GetAdvertisementBean;
import com.capstone.planet.Model.DTO.ResponseAdvertisementGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementService {

    GetAdvertisementBean getAdvertisementBean;

    @Autowired
    public AdvertisementService(GetAdvertisementBean getAdvertisementBean) {
        this.getAdvertisementBean = getAdvertisementBean;
    }

    // 광고 전체 조회
    public List<ResponseAdvertisementGetDTO> getAdvertisement(){
        return getAdvertisementBean.exec();
    }
}
