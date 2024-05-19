package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.GetPostDAOBean;
import com.capstone.planet.Model.DAO.PostDAO;
import com.capstone.planet.Model.DTO.ResponseViewPostGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetViewPostBean {

    @Autowired
    GetPostDAOBean getPostDAOBean;

    // 조회수 기준 게시물 조회
    public ResponseViewPostGetDTO exec(String type){
        PostDAO postDAO = getPostDAOBean.exec(type, 1L);

        return ResponseViewPostGetDTO.builder()
                .postId(postDAO.getPostId())
                .title(postDAO.getTitle())
                .viewCount(postDAO.getViewCount())
                .build();
    }
}
