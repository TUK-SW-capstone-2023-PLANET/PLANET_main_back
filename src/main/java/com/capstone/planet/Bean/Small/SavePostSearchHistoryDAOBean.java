package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.PostSearchHistoryDAO;
import com.capstone.planet.Repository.PostSearchHistoryRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SavePostSearchHistoryDAOBean {

    PostSearchHistoryRepositoryJPA postSearchHistoryRepositoryJPA;

    @Autowired
    public SavePostSearchHistoryDAOBean(PostSearchHistoryRepositoryJPA postSearchHistoryRepositoryJPA) {
        this.postSearchHistoryRepositoryJPA = postSearchHistoryRepositoryJPA;
    }

    // 게시글 검색 히스토리 저장
    public void exec(PostSearchHistoryDAO postSearchHistoryDAO){
        postSearchHistoryRepositoryJPA.save(postSearchHistoryDAO);
    }
}
