package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.PostHeartDAO;
import com.capstone.planet.Repository.PostHeartRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SavePostHeartDAOBean {

    PostHeartRepositoryJPA postHeartRepositoryJPA;

    @Autowired
    public SavePostHeartDAOBean(PostHeartRepositoryJPA postHeartRepositoryJPA) {
        this.postHeartRepositoryJPA = postHeartRepositoryJPA;
    }

    // 게시물 좋아요 저장
    public void exec(PostHeartDAO postHeartDAO) {
        postHeartRepositoryJPA.save(postHeartDAO);
    }
}
