package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.CommentDAO;
import com.capstone.planet.Model.DTO.RequestCommentSaveDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CreateCommentDAOBean {

    // 댓글 DAO 생성
    public CommentDAO exec(Long commentId, RequestCommentSaveDTO requestCommentSaveDTO) {

        return CommentDAO.builder()
                .commentId(commentId)
                .postId(requestCommentSaveDTO.getPostId())
                .userId(requestCommentSaveDTO.getUserId())
                .content(requestCommentSaveDTO.getContent())
                .heartCount(0)
                .uploadTime(LocalDateTime.now())
                .build();
    }
}
