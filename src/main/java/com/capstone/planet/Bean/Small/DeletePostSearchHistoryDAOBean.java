package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.PostSearchHistoryDAO;
import com.capstone.planet.Repository.PostSearchHistoryRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeletePostSearchHistoryDAOBean {

    PostSearchHistoryRepositoryJPA postSearchHistoryRepositoryJPA;

    @Autowired
    public DeletePostSearchHistoryDAOBean(PostSearchHistoryRepositoryJPA postSearchHistoryRepositoryJPA) {
        this.postSearchHistoryRepositoryJPA = postSearchHistoryRepositoryJPA;
    }

    // 게시물 검색 히스토리 삭제
    public void exec(List<PostSearchHistoryDAO> postSearchHistoryDAOS){
        postSearchHistoryRepositoryJPA.deleteAll(postSearchHistoryDAOS);
    }
}
