package com.capstone.planet.Bean.Small;

import com.capstone.planet.Repository.CommentRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DeleteCommentDAOBean {

    CommentRepositoryJPA commentRepositoryJPA;

    @Autowired
    public DeleteCommentDAOBean(CommentRepositoryJPA commentRepositoryJPA) {
        this.commentRepositoryJPA = commentRepositoryJPA;
    }

    // 게시물에 해당하는 댓글 전체 삭제
    @Transactional
    public void exec(Long postId) {
        commentRepositoryJPA.deleteAllByPostId(postId);
    }
}
