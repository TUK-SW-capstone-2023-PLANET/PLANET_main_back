package com.capstone.planet.Bean;

import com.capstone.planet.Model.DTO.ResponseChatRoomGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetSearchChatBean {

    GetChatRoomsBean getChatRoomsBean;

    @Autowired
    public GetSearchChatBean(GetChatRoomsBean getChatRoomsBean) {
        this.getChatRoomsBean = getChatRoomsBean;
    }

    // 쪽지함 검색
    public List<ResponseChatRoomGetDTO> exec(Long userId, String search) {

        List<ResponseChatRoomGetDTO> responseChatRoomGetDTOS = getChatRoomsBean.exec(userId);

        return responseChatRoomGetDTOS.stream()
                .filter(responseChatRoomGetDTO -> responseChatRoomGetDTO.getPartnerUserName().contains(search))
                .collect(Collectors.toList());

    }
}
