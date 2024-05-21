package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.ChatRoomDAO;
import com.capstone.planet.Model.DAO.UserDAO;
import com.capstone.planet.Model.DTO.ResponseChatRoomGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class CreateChatRoomDTOBean {

    GetUserDAOBean getUserDAOBean;

    @Autowired
    public CreateChatRoomDTOBean(GetUserDAOBean getUserDAOBean){
        this.getUserDAOBean = getUserDAOBean;
    }

    public ResponseChatRoomGetDTO exec(Long userId, ChatRoomDAO chatRoomDAO){

        Long partnerUserId = userId.equals(chatRoomDAO.getUserOneId()) ? chatRoomDAO.getUserTwoId() : chatRoomDAO.getUserOneId();
        String uploadTime = chatRoomDAO.getUploadTime().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));

        UserDAO partnerUserDAO = getUserDAOBean.exec(partnerUserId);

        return ResponseChatRoomGetDTO.builder()
                .chatRoomId(chatRoomDAO.getChatRoomId())
                .partnerUserId(partnerUserId)
                .partnerUserName(partnerUserDAO.getNickName())
                .partnerUserImage(partnerUserDAO.getImageUrl())
                .content(chatRoomDAO.getContent())
                .uploadTime(uploadTime)
                .build();
    }

    public List<ResponseChatRoomGetDTO> exec(Long userId, List<ChatRoomDAO> chatRoomDAOS){
        List<ResponseChatRoomGetDTO> responseChatRoomGetDTOS = new ArrayList<>();
        for (ChatRoomDAO chatRoomDAO : chatRoomDAOS) {
            responseChatRoomGetDTOS.add(exec(userId, chatRoomDAO));
        }
        return responseChatRoomGetDTOS;
    }
}
