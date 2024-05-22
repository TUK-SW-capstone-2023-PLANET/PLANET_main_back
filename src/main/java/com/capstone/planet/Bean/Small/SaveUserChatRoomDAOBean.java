package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.UserChatRoomDAO;
import com.capstone.planet.Repository.UserChatRoomRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveUserChatRoomDAOBean {

    UserChatRoomRepositoryJPA userChatRoomRepositoryJPA;

    @Autowired
    public SaveUserChatRoomDAOBean(UserChatRoomRepositoryJPA userChatRoomRepositoryJPA) {
        this.userChatRoomRepositoryJPA = userChatRoomRepositoryJPA;
    }

    // 유저 채팅방 저장
    public void exec(UserChatRoomDAO userChatRoomDAO){
        userChatRoomRepositoryJPA.save(userChatRoomDAO);
    }
}
