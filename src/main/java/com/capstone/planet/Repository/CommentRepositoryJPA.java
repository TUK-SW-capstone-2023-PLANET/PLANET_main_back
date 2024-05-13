package com.capstone.planet.Repository;

import com.capstone.planet.Model.DAO.CommentDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepositoryJPA extends JpaRepository<CommentDAO, Long>{

    List<CommentDAO> findAllByPostId(Long postId);

    void deleteAllByPostId(Long postId);
}
