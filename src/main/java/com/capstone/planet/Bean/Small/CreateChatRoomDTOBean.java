package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.ChatRoomDAO;
import com.capstone.planet.Model.DAO.UserChatRoomDAO;
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
    GetUserChatRoomDAOBean getUserChatRoomDAOBean;

    @Autowired
    public CreateChatRoomDTOBean(GetUserDAOBean getUserDAOBean, GetUserChatRoomDAOBean getUserChatRoomDAOBean){
        this.getUserDAOBean = getUserDAOBean;
        this.getUserChatRoomDAOBean = getUserChatRoomDAOBean;
    }

    public ResponseChatRoomGetDTO exec(Long userId, ChatRoomDAO chatRoomDAO){

        Long partnerUserId = userId.equals(chatRoomDAO.getUserOneId()) ? chatRoomDAO.getUserTwoId() : chatRoomDAO.getUserOneId();
        String uploadTime = chatRoomDAO.getUploadTime().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));

        if (getUserChatRoomDAOBean.exec(userId, chatRoomDAO.getChatRoomId()).isDeleteCheck())
            return null;

        UserDAO partnerUserDAO = getUserDAOBean.exec(partnerUserId);
        UserChatRoomDAO userChatRoomDAO = getUserChatRoomDAOBean.exec(userId, chatRoomDAO.getChatRoomId());
        boolean newType = userChatRoomDAO.isNewType();

        return ResponseChatRoomGetDTO.builder()
                .chatRoomId(chatRoomDAO.getChatRoomId())
                .partnerUserId(partnerUserId)
                .partnerUserName(partnerUserDAO.getNickName())
                .partnerUserImage(partnerUserDAO.getImageUrl())
                .content(chatRoomDAO.getContent())
                .uploadTime(uploadTime)
                .newType(newType)
                .build();
    }

    public List<ResponseChatRoomGetDTO> exec(Long userId, List<ChatRoomDAO> chatRoomDAOS){
        List<ResponseChatRoomGetDTO> responseChatRoomGetDTOS = new ArrayList<>();
        for (ChatRoomDAO chatRoomDAO : chatRoomDAOS) {
            ResponseChatRoomGetDTO exec = exec(userId, chatRoomDAO);
            if (exec != null)
                responseChatRoomGetDTOS.add(exec);
        }
        return responseChatRoomGetDTOS;
    }
}
