package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.ChatDAO;
import com.capstone.planet.Model.DTO.ResponseChatGetDTO;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class CreateChatDTOBean {

    public ResponseChatGetDTO exec(Long userId, String userImage, String partnerUserImage, ChatDAO chatDAO) {

        String type = chatDAO.getSenderId().equals(userId) ? "보낸 쪽지" : "받은 쪽지";
        String senderImage = chatDAO.getSenderId().equals(userId) ? userImage : partnerUserImage;
        String uploadTime = chatDAO.getUploadTime().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));

        return ResponseChatGetDTO.builder()
                .chatId(chatDAO.getChatId())
                .content(chatDAO.getContent())
                .senderImage(senderImage)
                .type(type)
                .uploadTime(uploadTime)
                .build();
    }

    public List<ResponseChatGetDTO> exec(Long userId, String userImage, String partnerUserImage, List<ChatDAO> chatDAOS) {
        List<ResponseChatGetDTO> responseChatGetDTOS = new ArrayList<>();
        for (ChatDAO chatDAO : chatDAOS) {
            responseChatGetDTOS.add(exec(userId, userImage, partnerUserImage, chatDAO));
        }
        return responseChatGetDTOS;
    }
}
