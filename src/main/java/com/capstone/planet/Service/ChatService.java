package com.capstone.planet.Service;

import com.capstone.planet.Bean.SaveChatBean;
import com.capstone.planet.Model.DTO.RequestChatSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    SaveChatBean saveChatBean;

    @Autowired
    public ChatService(SaveChatBean saveChatBean) {
        this.saveChatBean = saveChatBean;
    }

    // 채팅 저장
    public Long saveChat(RequestChatSaveDTO requestChatSaveDTO) {
        return saveChatBean.exec(requestChatSaveDTO);
    }
}
