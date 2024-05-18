package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.CommentHeartDAO;
import com.capstone.planet.Repository.CommentHeartRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveCommentHeartDAOBean {

    CommentHeartRepositoryJPA commentHeartRepositoryJPA;

    @Autowired
    public SaveCommentHeartDAOBean(CommentHeartRepositoryJPA commentHeartRepositoryJPA) {
        this.commentHeartRepositoryJPA = commentHeartRepositoryJPA;
    }

    // 댓글 좋아요 저장
    public void exec(CommentHeartDAO commentHeartDAO){
        commentHeartRepositoryJPA.save(commentHeartDAO);
    }
}
