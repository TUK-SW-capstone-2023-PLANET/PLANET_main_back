package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.CommentHeartDAO;
import com.capstone.planet.Model.DTO.RequestCommentHeartSaveDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateCommentHeartDAOBean {

    // 댓글 좋아요 DAO 생성
    public CommentHeartDAO exec(Long commentHeartId, RequestCommentHeartSaveDTO requestCommentHeartSaveDTO){
        return CommentHeartDAO.builder()
                .commentHeartId(commentHeartId)
                .commentId(requestCommentHeartSaveDTO.getCommentId())
                .userId(requestCommentHeartSaveDTO.getUserId())
                .build();
    }
}
