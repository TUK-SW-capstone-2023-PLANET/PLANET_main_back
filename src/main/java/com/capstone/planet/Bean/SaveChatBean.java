package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.*;
import com.capstone.planet.Model.DAO.ChatDAO;
import com.capstone.planet.Model.DAO.ChatRoomDAO;
import com.capstone.planet.Model.DAO.UserChatRoomDAO;
import com.capstone.planet.Model.DTO.RequestChatSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SaveChatBean {

    GetChatRoomDAOBean getChatRoomDAOBean;
    CreateUniqueIdBean createUniqueIdBean;
    CreateChatDAOBean createChatDAOBean;
    SaveChatDAOBean saveChatDAOBean;
    SaveChatRoomDAOBean saveChatRoomDAOBean;
    SaveUserChatRoomDAOBean saveUserChatRoomDAOBean;
    GetUserChatRoomDAOBean getUserChatRoomDAOBean;

    @Autowired
    public SaveChatBean(GetChatRoomDAOBean getChatRoomDAOBean, CreateUniqueIdBean createUniqueIdBean, CreateChatDAOBean createChatDAOBean, SaveChatDAOBean saveChatDAOBean, SaveChatRoomDAOBean saveChatRoomDAOBean, SaveUserChatRoomDAOBean saveUserChatRoomDAOBean, GetUserChatRoomDAOBean getUserChatRoomDAOBean) {
        this.getChatRoomDAOBean = getChatRoomDAOBean;
        this.createUniqueIdBean = createUniqueIdBean;
        this.createChatDAOBean = createChatDAOBean;
        this.saveChatDAOBean = saveChatDAOBean;
        this.saveChatRoomDAOBean = saveChatRoomDAOBean;
        this.saveUserChatRoomDAOBean = saveUserChatRoomDAOBean;
        this.getUserChatRoomDAOBean = getUserChatRoomDAOBean;
    }

    // 채팅 저장
    public Long exec(RequestChatSaveDTO requestChatSaveDTO) {

        ChatRoomDAO chatRoomDAO = getChatRoomDAOBean.exec(requestChatSaveDTO.getReceiverId(), requestChatSaveDTO.getSenderId());

        // 채팅방 있는 경우
        if (chatRoomDAO != null) {
            Long chatId = createUniqueIdBean.exec();

            // 채팅 저장
            ChatDAO chatDAO = createChatDAOBean.exec(chatId, chatRoomDAO.getChatRoomId(), requestChatSaveDTO);

            // 채팅방 최근 채팅 수정
            chatRoomDAO.setContent(requestChatSaveDTO.getContent());
            chatRoomDAO.setContentUploadTime(LocalDateTime.now());

            // 채팅 받은 유저 newType 변경
            UserChatRoomDAO userChatRoomDAO = getUserChatRoomDAOBean.exec(requestChatSaveDTO.getReceiverId(), chatRoomDAO.getChatRoomId());
            userChatRoomDAO.setNewType(true);


            saveChatDAOBean.exec(chatDAO);
            saveChatRoomDAOBean.exec(chatRoomDAO);
            saveUserChatRoomDAOBean.exec(userChatRoomDAO);

            return chatId;
        }
        // 채팅방 없는 경우
        else {
            Long chatRoomId = createUniqueIdBean.exec();
            Long chatId = createUniqueIdBean.exec();

            // 채팅 DAO 생성
            ChatDAO chatDAO = createChatDAOBean.exec(chatId, chatRoomId, requestChatSaveDTO);

            // 채팅방 생성
            chatRoomDAO = ChatRoomDAO.builder()
                    .chatRoomId(chatRoomId)
                    .userOneId(requestChatSaveDTO.getSenderId())
                    .userTwoId(requestChatSaveDTO.getReceiverId())
                    .content(requestChatSaveDTO.getContent())
                    .contentUploadTime(LocalDateTime.now())
                    .build();

            UserChatRoomDAO senderChatRoomDAO = UserChatRoomDAO.builder()
                    .userChatRoomId(createUniqueIdBean.exec())
                    .userId(requestChatSaveDTO.getSenderId())
                    .chatRoomId(chatRoomId)
                    .newType(false)
                    .deleteCheck(false)
                    .build();

            UserChatRoomDAO buyerChatRoomDAO = UserChatRoomDAO.builder()
                    .userChatRoomId(createUniqueIdBean.exec())
                    .userId(requestChatSaveDTO.getReceiverId())
                    .chatRoomId(chatRoomId)
                    .newType(true)
                    .deleteCheck(false)
                    .build();

            saveUserChatRoomDAOBean.exec(senderChatRoomDAO);
            saveUserChatRoomDAOBean.exec(buyerChatRoomDAO);
            saveChatDAOBean.exec(chatDAO);
            saveChatRoomDAOBean.exec(chatRoomDAO);

            return chatId;
        }
    }
}
