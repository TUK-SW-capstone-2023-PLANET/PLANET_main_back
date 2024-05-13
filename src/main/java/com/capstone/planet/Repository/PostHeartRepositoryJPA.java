package com.capstone.planet.Repository;

import com.capstone.planet.Model.DAO.PostHeartDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostHeartRepositoryJPA extends JpaRepository<PostHeartDAO, Long> {

    PostHeartDAO findByUserIdAndPostId(Long userId, Long postId);
}
