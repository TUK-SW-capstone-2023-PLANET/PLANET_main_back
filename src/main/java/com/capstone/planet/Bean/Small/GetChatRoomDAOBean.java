package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.ChatRoomDAO;
import com.capstone.planet.Repository.ChatRoomRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetChatRoomDAOBean {

    ChatRoomRepositoryJPA chatRoomRepositoryJPA;

    @Autowired
    public GetChatRoomDAOBean(ChatRoomRepositoryJPA chatRoomRepositoryJPA) {
        this.chatRoomRepositoryJPA = chatRoomRepositoryJPA;
    }

    // 유저 아이디 2개로 채팅방 조회
    public ChatRoomDAO exec(Long userOneId, Long userTwoId){

        ChatRoomDAO byUserOneIdAndUserTwoId = chatRoomRepositoryJPA.findByUserOneIdAndUserTwoId(userOneId, userTwoId);

        ChatRoomDAO byUserOneIdAndUserTwoId1 = chatRoomRepositoryJPA.findByUserOneIdAndUserTwoId(userTwoId, userOneId);

        if (byUserOneIdAndUserTwoId != null) return byUserOneIdAndUserTwoId;
        else return byUserOneIdAndUserTwoId1;
    }
}
