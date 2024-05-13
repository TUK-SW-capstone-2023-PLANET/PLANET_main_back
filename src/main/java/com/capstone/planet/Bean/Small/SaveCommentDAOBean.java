package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.CommentDAO;
import com.capstone.planet.Repository.CommentRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveCommentDAOBean {

    CommentRepositoryJPA commentRepositoryJPA;

    @Autowired
    public SaveCommentDAOBean(CommentRepositoryJPA commentRepositoryJPA) {
        this.commentRepositoryJPA = commentRepositoryJPA;
    }

    // 댓글 저장
    public void exec(CommentDAO commentDAO) {
        commentRepositoryJPA.save(commentDAO);
    }
}
