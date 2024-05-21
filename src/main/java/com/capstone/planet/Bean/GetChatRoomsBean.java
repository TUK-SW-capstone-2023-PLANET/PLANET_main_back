package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.CreateChatRoomDTOBean;
import com.capstone.planet.Bean.Small.GetChatRoomDAOBean;
import com.capstone.planet.Model.DAO.ChatRoomDAO;
import com.capstone.planet.Model.DTO.ResponseChatRoomGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class GetChatRoomsBean {

    GetChatRoomDAOBean getChatRoomDAOBean;
    CreateChatRoomDTOBean createChatRoomDTOBean;

    @Autowired
    public GetChatRoomsBean(GetChatRoomDAOBean getChatRoomDAOBean, CreateChatRoomDTOBean createChatRoomDTOBean) {
        this.getChatRoomDAOBean = getChatRoomDAOBean;
        this.createChatRoomDTOBean = createChatRoomDTOBean;
    }

    // 채팅방 전체 조회
    public List<ResponseChatRoomGetDTO> exec(Long userId){

        // 채팅방 시간순으로 가져오기
        List<ChatRoomDAO> chatRoomDAOS1 = getChatRoomDAOBean.exec(userId, 0L, 0L);
        List<ChatRoomDAO> chatRoomDAOS2 = getChatRoomDAOBean.exec(userId, 0L, 1L, 0L);

        if (chatRoomDAOS1 == null && chatRoomDAOS2 == null) return new ArrayList<>();

        List<ChatRoomDAO> safeList1 = chatRoomDAOS1 != null ? chatRoomDAOS1 : Collections.emptyList();
        List<ChatRoomDAO> safeList2 = chatRoomDAOS2 != null ? chatRoomDAOS2 : Collections.emptyList();


        List<ChatRoomDAO> chatRoomDAOS = Stream.concat(safeList1.stream(), safeList2.stream())
                // uploadTime 필드를 기준으로 내림차순 정렬
                .sorted(Comparator.comparing(ChatRoomDAO::getUploadTime).reversed())
                // 정렬된 결과를 리스트로 변환
                .collect(Collectors.toList());

        //List<ChatRoomDAO> chatRoomDAOS = getChatRoomDAOBean.exec(userId, "check");

        return createChatRoomDTOBean.exec(userId, chatRoomDAOS);
    }
}
