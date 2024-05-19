package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.CommentDAO;
import com.capstone.planet.Repository.CommentRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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

    // 게시물에 해당하는 댓글 전체 조회
    public List<CommentDAO> exec(Long postId, Long check){
        return commentRepositoryJPA.findAllByPostId(postId);
    }

    // 내가 쓴 댓글 전부 가졍호기
    public List<CommentDAO> exec(Long userId, String check){
        return commentRepositoryJPA.findAllByUserId(userId);
    }
}
