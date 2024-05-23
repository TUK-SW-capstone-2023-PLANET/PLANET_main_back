package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.ChatDAO;
import com.capstone.planet.Repository.ChatRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class DeleteChatDAOBean {

    ChatRepositoryJPA chatRepositoryJPA;

    @Autowired
    public DeleteChatDAOBean(ChatRepositoryJPA chatRepositoryJPA) {
        this.chatRepositoryJPA = chatRepositoryJPA;
    }

    @Transactional
    public void exec(Long chatRoomId){
        chatRepositoryJPA.deleteAllByChatRoomId(chatRoomId);
    }
}
