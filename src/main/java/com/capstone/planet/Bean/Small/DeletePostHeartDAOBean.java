package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.PostHeartDAO;
import com.capstone.planet.Repository.PostHeartRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeletePostHeartDAOBean {

    PostHeartRepositoryJPA postHeartRepositoryJPA;

    @Autowired
    public DeletePostHeartDAOBean(PostHeartRepositoryJPA postHeartRepositoryJPA) {
        this.postHeartRepositoryJPA = postHeartRepositoryJPA;
    }

    // 게시물 좋아요 삭제
    public void exec(PostHeartDAO postHeartDAO) {
        postHeartRepositoryJPA.delete(postHeartDAO);
    }
}
