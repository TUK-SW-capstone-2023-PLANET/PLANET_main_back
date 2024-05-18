package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.CommentHeartDAO;
import com.capstone.planet.Repository.CommentHeartRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCommentHeartDAOBean {

    CommentHeartRepositoryJPA commentHeartRepositoryJPA;

    @Autowired
    public DeleteCommentHeartDAOBean(CommentHeartRepositoryJPA commentHeartRepositoryJPA) {
        this.commentHeartRepositoryJPA = commentHeartRepositoryJPA;
    }

    // 댓글 좋아요 삭제
    public void exec(CommentHeartDAO commentHeartDAO){
        commentHeartRepositoryJPA.delete(commentHeartDAO);
    }
}
