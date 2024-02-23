package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.ImageDAO;
import com.capstone.planet.Repository.ImageRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveImageDAOBean {

    ImageRepositoryJPA imageRepositoryJPA;

    @Autowired
    public SaveImageDAOBean(ImageRepositoryJPA imageRepositoryJPA) {
        this.imageRepositoryJPA = imageRepositoryJPA;
    }

    // 이미지 저장
    public void exec(ImageDAO image){
        imageRepositoryJPA.save(image);
    }
}
