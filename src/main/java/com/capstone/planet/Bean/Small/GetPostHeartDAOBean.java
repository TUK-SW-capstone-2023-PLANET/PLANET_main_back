package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.PostHeartDAO;
import com.capstone.planet.Repository.PostHeartRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetPostHeartDAOBean {

    PostHeartRepositoryJPA postHeartRepositoryJPA;

    @Autowired
    public GetPostHeartDAOBean(PostHeartRepositoryJPA postHeartRepositoryJPA) {
        this.postHeartRepositoryJPA = postHeartRepositoryJPA;
    }

    // 게시물 좋아요 여부 확인
    public PostHeartDAO exec(Long userId, Long postId) {
        return postHeartRepositoryJPA.findByUserIdAndPostId(userId, postId);
    }
}
