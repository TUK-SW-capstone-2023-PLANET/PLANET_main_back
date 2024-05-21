package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.CreateChatDTOBean;
import com.capstone.planet.Bean.Small.GetChatDAOBean;
import com.capstone.planet.Bean.Small.GetChatRoomDAOBean;
import com.capstone.planet.Bean.Small.GetUserDAOBean;
import com.capstone.planet.Model.DAO.ChatDAO;
import com.capstone.planet.Model.DAO.ChatRoomDAO;
import com.capstone.planet.Model.DAO.UserDAO;
import com.capstone.planet.Model.DTO.ResponseChatGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetChatsBean {

    GetChatRoomDAOBean getChatRoomDAOBean;
    GetChatDAOBean getChatDAOBean;
    GetUserDAOBean getUserDAOBean;
    CreateChatDTOBean createChatDTOBean;

    @Autowired
    public GetChatsBean(GetChatRoomDAOBean getChatRoomDAOBean, GetChatDAOBean getChatDAOBean, GetUserDAOBean getUserDAOBean, CreateChatDTOBean createChatDTOBean) {
        this.getChatRoomDAOBean = getChatRoomDAOBean;
        this.getChatDAOBean = getChatDAOBean;
        this.getUserDAOBean = getUserDAOBean;
        this.createChatDTOBean = createChatDTOBean;
    }

    // 채팅방 채팅 내역 조회
    public List<ResponseChatGetDTO> exec(Long chatRoomId, Long userId) {

        // 채팅방 정보 조회
        ChatRoomDAO chatRoomDAO = getChatRoomDAOBean.exec(chatRoomId);
        if (chatRoomDAO == null) return null;

        Long partnerUserId;
        if (chatRoomDAO.getUserOneId().equals(Long.parseLong(userId.toString())))
            partnerUserId = chatRoomDAO.getUserTwoId();
        else
            partnerUserId = chatRoomDAO.getUserOneId();

        // 내 정보
        UserDAO userDAO = getUserDAOBean.exec(userId);

        // 파트너 정보
        UserDAO partnerUserDAO = getUserDAOBean.exec(partnerUserId);

        // 채팅방 채팅 내역 조회
        List<ChatDAO> chatDAOS = getChatDAOBean.exec(chatRoomId);

        // 채팅 내역 반환
        return createChatDTOBean.exec(userId, userDAO.getImageUrl(), partnerUserDAO.getImageUrl(), chatDAOS);
    }
}
