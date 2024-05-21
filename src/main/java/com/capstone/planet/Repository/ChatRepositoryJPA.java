package com.capstone.planet.Repository;

import com.capstone.planet.Model.DAO.ChatDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepositoryJPA extends JpaRepository<ChatDAO, Long> {

    // 채팅방 아이디로 채팅내역 시간순 조회
    List<ChatDAO> findByChatRoomIdOrderByUploadTimeDesc(Long chatRoomId);
}
