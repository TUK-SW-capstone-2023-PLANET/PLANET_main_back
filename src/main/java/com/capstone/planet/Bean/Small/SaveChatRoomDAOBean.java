package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.ChatRoomDAO;
import com.capstone.planet.Repository.ChatRoomRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveChatRoomDAOBean {

    ChatRoomRepositoryJPA chatRoomRepositoryJPA;

    @Autowired
    public SaveChatRoomDAOBean(ChatRoomRepositoryJPA chatRoomRepositoryJPA) {
        this.chatRoomRepositoryJPA = chatRoomRepositoryJPA;
    }

    // 채팅방 저장
    public void exec(ChatRoomDAO chatRoomDAO){
        chatRoomRepositoryJPA.save(chatRoomDAO);
    }
}
