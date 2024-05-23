package com.capstone.planet.Bean.Small;


import com.capstone.planet.Repository.ChatRoomRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DeleteChatRoomDAOBean {

    ChatRoomRepositoryJPA chatRoomRepositoryJPA;

    @Autowired
    public DeleteChatRoomDAOBean(ChatRoomRepositoryJPA chatRoomRepositoryJPA) {
        this.chatRoomRepositoryJPA = chatRoomRepositoryJPA;
    }

    @Transactional
    public void exec(Long chatRoomId){
        chatRoomRepositoryJPA.deleteById(chatRoomId);
    }
}
