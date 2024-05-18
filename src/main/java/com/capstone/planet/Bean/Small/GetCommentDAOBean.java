package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.CommentDAO;
import com.capstone.planet.Repository.CommentRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetCommentDAOBean {

    CommentRepositoryJPA commentRepositoryJPA;

    @Autowired
    public GetCommentDAOBean(CommentRepositoryJPA commentRepositoryJPA) {
        this.commentRepositoryJPA = commentRepositoryJPA;
    }

    // 댓글 조회
    public CommentDAO exec(Long commentId){
        return commentRepositoryJPA.findById(commentId).orElse(null);
    }
}
