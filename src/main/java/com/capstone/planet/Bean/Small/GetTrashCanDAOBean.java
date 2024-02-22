package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.TrashCanDAO;
import com.capstone.planet.Repository.TrashCanRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetTrashCanDAOBean {

    TrashCanRepositoryJPA trashCanRepositoryJPA;

    @Autowired
    public GetTrashCanDAOBean(TrashCanRepositoryJPA trashCanRepositoryJPA) {
        this.trashCanRepositoryJPA = trashCanRepositoryJPA;
    }

    // 쓰레기통 정보 가져오기
    public TrashCanDAO exec(Long trashCanId){
        return trashCanRepositoryJPA.findById(trashCanId).orElse(null);
    }
    
    // 쓰레기통 정보 전부 가져오기
    public List<TrashCanDAO> exec(){
        return trashCanRepositoryJPA.findAll();
    }
}
