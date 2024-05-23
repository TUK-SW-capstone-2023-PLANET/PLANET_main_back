package com.capstone.planet.Bean.Small;

import com.capstone.planet.Repository.UserChatRoomRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DeleteUserChatRoomDAOBean {

    UserChatRoomRepositoryJPA userChatRoomRepositoryJPA;

    @Autowired
    public DeleteUserChatRoomDAOBean(UserChatRoomRepositoryJPA userChatRoomRepositoryJPA) {
        this.userChatRoomRepositoryJPA = userChatRoomRepositoryJPA;
    }

    @Transactional
    public void exec(Long chatRoomId){
        userChatRoomRepositoryJPA.deleteAllByChatRoomId(chatRoomId);
    }
}
