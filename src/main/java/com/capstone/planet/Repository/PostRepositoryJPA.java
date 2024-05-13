package com.capstone.planet.Repository;

import com.capstone.planet.Model.DAO.PostDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepositoryJPA extends JpaRepository<PostDAO, Long> {
}
