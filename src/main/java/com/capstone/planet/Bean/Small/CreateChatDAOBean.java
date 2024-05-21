package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.ChatDAO;
import com.capstone.planet.Model.DTO.RequestChatSaveDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateChatDAOBean {

    public ChatDAO exec(Long chatId, Long chatRoomId, RequestChatSaveDTO requestChatSaveDTO){
        return ChatDAO.builder()
                .chatId(chatId)
                .chatRoomId(chatRoomId)
                .senderId(requestChatSaveDTO.getSenderId())
                .receiverId(requestChatSaveDTO.getReceiverId())
                .content(requestChatSaveDTO.getContent())
                .build();
    }
}
