package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.CommentHeartDAO;
import com.capstone.planet.Repository.CommentHeartRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetCommentHeartDAOBean {

    CommentHeartRepositoryJPA commentHeartRepositoryJPA;

    @Autowired
    public GetCommentHeartDAOBean(CommentHeartRepositoryJPA commentHeartRepositoryJPA) {
        this.commentHeartRepositoryJPA = commentHeartRepositoryJPA;
    }

    // 댓글 좋아요 중복 배제
    public CommentHeartDAO exec(Long commentId, Long userId){
        return commentHeartRepositoryJPA.findByCommentIdAndUserId(commentId, userId);
    }
}
