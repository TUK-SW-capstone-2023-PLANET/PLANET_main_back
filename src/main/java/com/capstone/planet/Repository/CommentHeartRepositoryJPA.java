package com.capstone.planet.Repository;

import com.capstone.planet.Model.DAO.CommentHeartDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentHeartRepositoryJPA extends JpaRepository<CommentHeartDAO, Long> {

    CommentHeartDAO findByCommentIdAndUserId(Long commentId, Long userId);
}
