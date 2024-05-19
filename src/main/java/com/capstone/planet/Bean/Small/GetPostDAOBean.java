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

    // 자유 게시판 인기 게시글 전체 조회
    public List<PostDAO> exec() {
        return postRepositoryJPA.findTop10ByTypeOrderByHeartCountDescUploadTimeDesc("free");
    }

    // 인기 게시물 조회
    public PostDAO exec(String type, String check){
        return postRepositoryJPA.findTop1ByTypeOrderByHeartCountDescUploadTimeDesc(type);
    }

    // 조회수 기준 게시물 조회
    public PostDAO exec(String type, Long check){
        return postRepositoryJPA.findTop1ByTypeOrderByViewCountDescUploadTimeDesc(type);
    }
}
