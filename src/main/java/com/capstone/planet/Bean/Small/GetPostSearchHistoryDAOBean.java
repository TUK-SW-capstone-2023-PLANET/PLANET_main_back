package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.PostSearchHistoryDAO;
import com.capstone.planet.Repository.PostSearchHistoryRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetPostSearchHistoryDAOBean {

    PostSearchHistoryRepositoryJPA postSearchHistoryRepositoryJPA;

    @Autowired
    public GetPostSearchHistoryDAOBean(PostSearchHistoryRepositoryJPA postSearchHistoryRepositoryJPA) {
        this.postSearchHistoryRepositoryJPA = postSearchHistoryRepositoryJPA;
    }

    // 게시물 검색 히스토리 조회
    public List<PostSearchHistoryDAO> exec(Long userId){
        return postSearchHistoryRepositoryJPA.findByUserIdOrderByUploadTimeDesc(userId);
    }
}
