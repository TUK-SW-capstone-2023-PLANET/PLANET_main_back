package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.ChatDAO;
import com.capstone.planet.Repository.ChatRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveChatDAOBean {

    ChatRepositoryJPA chatRepositoryJPA;

    @Autowired
    public SaveChatDAOBean(ChatRepositoryJPA chatRepositoryJPA) {
        this.chatRepositoryJPA = chatRepositoryJPA;
    }

    // 채팅 저장
    public void exec(ChatDAO chatDAO){
        chatRepositoryJPA.save(chatDAO);
    }
}
