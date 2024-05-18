package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.PostDAO;
import com.capstone.planet.Repository.PostRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetPostDAOBean {

    PostRepositoryJPA postRepositoryJPA;

    @Autowired
    public GetPostDAOBean(PostRepositoryJPA postRepositoryJPA) {
        this.postRepositoryJPA = postRepositoryJPA;
    }

    // 게시물 찾기
    public PostDAO exec(Long postId) {
        return postRepositoryJPA.findById(postId).orElse(null);
    }

    // 게시물 type 별로 시간순 찾기
    public List<PostDAO> exec(String type) {
        return postRepositoryJPA.findByTypeOrderByUploadTimeDesc(type);
    }
}
