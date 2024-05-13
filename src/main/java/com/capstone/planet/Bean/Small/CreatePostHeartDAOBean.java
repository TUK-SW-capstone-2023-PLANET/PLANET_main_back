package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.PostHeartDAO;
import com.capstone.planet.Model.DTO.RequestPostHeartSaveDTO;
import org.springframework.stereotype.Component;

@Component
public class CreatePostHeartDAOBean {

    // 게시물 좋아요 DAO 생성
    public PostHeartDAO exec(Long postHeartId, RequestPostHeartSaveDTO requestPostHeartSaveDTO) {
        return PostHeartDAO.builder()
                .postHeartId(postHeartId)
                .postId(requestPostHeartSaveDTO.getPostId())
                .userId(requestPostHeartSaveDTO.getUserId())
                .build();
    }
}
