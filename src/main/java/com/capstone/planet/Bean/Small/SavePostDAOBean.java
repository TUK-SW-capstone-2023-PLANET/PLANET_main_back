package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.PostDAO;
import com.capstone.planet.Repository.PostRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SavePostDAOBean {

    PostRepositoryJPA postRepositoryJPA;

    @Autowired
    public SavePostDAOBean(PostRepositoryJPA postRepositoryJPA) {
        this.postRepositoryJPA = postRepositoryJPA;
    }

    // 게시물 저장
    public void exec(PostDAO postDAO) {
        postRepositoryJPA.save(postDAO);
    }
}
