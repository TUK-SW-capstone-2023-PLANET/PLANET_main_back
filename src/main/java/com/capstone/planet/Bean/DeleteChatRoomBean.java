package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.GetUserChatRoomDAOBean;
import com.capstone.planet.Bean.Small.SaveUserChatRoomDAOBean;
import com.capstone.planet.Model.DAO.UserChatRoomDAO;
import com.capstone.planet.Model.DTO.RequestChatRoomDeleteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteChatRoomBean {

    GetUserChatRoomDAOBean getUserChatRoomDAOBean;
    SaveUserChatRoomDAOBean saveUserChatRoomDAOBean;

    @Autowired
    public DeleteChatRoomBean(GetUserChatRoomDAOBean getUserChatRoomDAOBean, SaveUserChatRoomDAOBean saveUserChatRoomDAOBean) {
        this.getUserChatRoomDAOBean = getUserChatRoomDAOBean;
        this.saveUserChatRoomDAOBean = saveUserChatRoomDAOBean;
    }

    public Long exec(RequestChatRoomDeleteDTO requestChatRoomDeleteDTO) {

        // 채팅방 삭제
        UserChatRoomDAO userChatRoomDAO = getUserChatRoomDAOBean.exec(requestChatRoomDeleteDTO.getUserId(), requestChatRoomDeleteDTO.getChatRoomId());
        userChatRoomDAO.setDeleteCheck(true);

        saveUserChatRoomDAOBean.exec(userChatRoomDAO);

        return userChatRoomDAO.getChatRoomId();
    }
}
