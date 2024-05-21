package com.capstone.planet.Repository;

import com.capstone.planet.Model.DAO.ChatRoomDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRoomRepositoryJPA extends JpaRepository<ChatRoomDAO, Long>{

    ChatRoomDAO findByUserOneIdAndUserTwoId(Long userId, Long partnerId);
}
