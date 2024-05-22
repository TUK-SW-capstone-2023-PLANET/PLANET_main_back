package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.UserChatRoomDAO;
import com.capstone.planet.Repository.UserChatRoomRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetUserChatRoomDAOBean {

    UserChatRoomRepositoryJPA userChatRoomRepositoryJPA;

    @Autowired
    public GetUserChatRoomDAOBean(UserChatRoomRepositoryJPA userChatRoomRepositoryJPA) {
        this.userChatRoomRepositoryJPA = userChatRoomRepositoryJPA;
    }

    // 유저 채팅방 찾기
    public UserChatRoomDAO exec(Long userId, Long chatRoomId){
        return userChatRoomRepositoryJPA.findByUserIdAndChatRoomId(userId, chatRoomId);
    }
}
