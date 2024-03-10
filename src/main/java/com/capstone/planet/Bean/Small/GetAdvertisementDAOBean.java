package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.AdvertisementDAO;
import com.capstone.planet.Repository.AdvertisementRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAdvertisementDAOBean {

    AdvertisementRepositoryJPA advertisementRepositoryJPA;


    @Autowired
    public GetAdvertisementDAOBean(AdvertisementRepositoryJPA advertisementRepositoryJPA) {
        this.advertisementRepositoryJPA = advertisementRepositoryJPA;
    }

    public List<AdvertisementDAO> exec(){
        return advertisementRepositoryJPA.findAll();
    }
}
