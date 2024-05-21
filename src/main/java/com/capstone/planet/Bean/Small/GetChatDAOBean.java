package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.ChatDAO;
import com.capstone.planet.Repository.ChatRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetChatDAOBean {

    ChatRepositoryJPA chatRepositoryJPA;

    @Autowired
    public GetChatDAOBean(ChatRepositoryJPA chatRepositoryJPA) {
        this.chatRepositoryJPA = chatRepositoryJPA;
    }

    // 채팅방 아이디로 채팅내역 시간순 조회
    public List<ChatDAO> exec(Long chatRoomId) {
        return chatRepositoryJPA.findByChatRoomIdOrderByUploadTimeDesc(chatRoomId);
    }
}
