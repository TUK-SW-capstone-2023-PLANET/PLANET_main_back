package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.GetPostSearchHistoryDAOBean;
import com.capstone.planet.Model.DAO.PostSearchHistoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetPostHistoryBean {

    GetPostSearchHistoryDAOBean getPostSearchHistoryDAOBean;

    @Autowired
    public GetPostHistoryBean(GetPostSearchHistoryDAOBean getPostSearchHistoryDAOBean) {
        this.getPostSearchHistoryDAOBean = getPostSearchHistoryDAOBean;
    }

    // 게시물 히스토리 조회
    public List<String> exec(Long userId){

        List<PostSearchHistoryDAO> postSearchHistoryDAOS = getPostSearchHistoryDAOBean.exec(userId);

        if (postSearchHistoryDAOS == null) {
            return List.of();
        }
        else if (postSearchHistoryDAOS.size()<6)
            return postSearchHistoryDAOS.stream()
                    .map(PostSearchHistoryDAO::getSearch)
                    .toList();
        else
            return postSearchHistoryDAOS.subList(0, 5).stream()
                    .map(PostSearchHistoryDAO::getSearch)
                    .toList();

    }
}