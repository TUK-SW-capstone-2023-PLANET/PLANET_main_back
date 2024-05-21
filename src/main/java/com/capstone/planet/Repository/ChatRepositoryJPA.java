package com.capstone.planet.Repository;

import com.capstone.planet.Model.DAO.ChatDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepositoryJPA extends JpaRepository<ChatDAO, Long> {
}
