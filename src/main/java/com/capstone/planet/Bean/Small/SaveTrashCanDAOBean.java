package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.TrashCanDAO;
import com.capstone.planet.Repository.TrashCanRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveTrashCanDAOBean {

    TrashCanRepositoryJPA trashCanRepositoryJPA;

    @Autowired
    public SaveTrashCanDAOBean(TrashCanRepositoryJPA trashCanRepositoryJPA) {
        this.trashCanRepositoryJPA = trashCanRepositoryJPA;
    }

    // 쓰레기통 저장
    public void exec(TrashCanDAO trashCanDAO){
        trashCanRepositoryJPA.save(trashCanDAO);
    }
}
