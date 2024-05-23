package com.capstone.planet.Repository;

import com.capstone.planet.Model.DAO.UserChatRoomDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserChatRoomRepositoryJPA extends JpaRepository<UserChatRoomDAO, Long> {

    UserChatRoomDAO findByUserIdAndChatRoomId(Long userId, Long chatRoomId);

    void deleteAllByChatRoomId(Long chatRoomId);
}
