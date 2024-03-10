package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.CreateAdvertisementDTOBean;
import com.capstone.planet.Bean.Small.GetAdvertisementDAOBean;
import com.capstone.planet.Model.DAO.AdvertisementDAO;
import com.capstone.planet.Model.DTO.ResponseAdvertisementGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAdvertisementBean {

    GetAdvertisementDAOBean getAdvertisementDAOBean;
    CreateAdvertisementDTOBean createAdvertisementDTOBean;

    @Autowired
    public GetAdvertisementBean(GetAdvertisementDAOBean getAdvertisementDAOBean, CreateAdvertisementDTOBean createAdvertisementDTOBean) {
        this.getAdvertisementDAOBean = getAdvertisementDAOBean;
        this.createAdvertisementDTOBean = createAdvertisementDTOBean;
    }

    public List<ResponseAdvertisementGetDTO> exec(){

        List<AdvertisementDAO> advertisementDAOS = getAdvertisementDAOBean.exec();

        return createAdvertisementDTOBean.exec(advertisementDAOS);
    }
}
