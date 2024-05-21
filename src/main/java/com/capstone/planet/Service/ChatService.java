package com.capstone.planet.Service;

import com.capstone.planet.Bean.GetChatsBean;
import com.capstone.planet.Bean.SaveChatBean;
import com.capstone.planet.Model.DTO.RequestChatSaveDTO;
import com.capstone.planet.Model.DTO.ResponseChatGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {

    GetChatsBean getChatsBean;
    SaveChatBean saveChatBean;

    @Autowired
    public ChatService(GetChatsBean getChatsBean, SaveChatBean saveChatBean) {
        this.getChatsBean = getChatsBean;
        this.saveChatBean = saveChatBean;
    }

    // 채팅방 채팅 내역 조회
    public List<ResponseChatGetDTO> getChats(Long chatRoomId, Long userId) {
        return getChatsBean.exec(chatRoomId, userId);
    }

    // 채팅 저장
    public Long saveChat(RequestChatSaveDTO requestChatSaveDTO) {
        return saveChatBean.exec(requestChatSaveDTO);
    }
}
