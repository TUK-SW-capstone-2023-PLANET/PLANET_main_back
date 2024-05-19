package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.GetPostDAOBean;
import com.capstone.planet.Model.DAO.PostDAO;
import com.capstone.planet.Model.DTO.ResponseHotPostGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetHotPostBean {

    @Autowired
    GetPostDAOBean getPostDAOBean;

    // 인기 게시물 조회
    public ResponseHotPostGetDTO exec(String type){

        PostDAO postDAO = getPostDAOBean.exec(type, "check");

        return ResponseHotPostGetDTO.builder()
                .postId(postDAO.getPostId())
                .title(postDAO.getTitle())
                .heartCount(postDAO.getHeartCount())
                .build();
    }
}
