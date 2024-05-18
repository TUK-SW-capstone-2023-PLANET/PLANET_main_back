package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.CommentDAO;
import com.capstone.planet.Model.DAO.UserDAO;
import com.capstone.planet.Model.DTO.ResponseCommentGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class CreateCommentDTOBean {

    GetUserDAOBean getUserDAOBean;
    GetCommentHeartDAOBean getCommentHeartDAOBean;

    @Autowired
    public CreateCommentDTOBean(GetUserDAOBean getUserDAOBean, GetCommentHeartDAOBean getCommentHeartDAOBean) {
        this.getUserDAOBean = getUserDAOBean;
        this.getCommentHeartDAOBean = getCommentHeartDAOBean;
    }

    // 댓글 DTO 생성
    public ResponseCommentGetDTO exec(Long userId, CommentDAO commentDAO){

        UserDAO userDAO = getUserDAOBean.exec(commentDAO.getUserId());
        if (userDAO == null) return null;

        LocalDateTime now = LocalDateTime.now().plusHours(9);
        Duration duration = Duration.between(commentDAO.getUploadTime(), now);

        long seconds = duration.getSeconds();
        long minutes = seconds / 60;
        long hours = minutes / 60;
        long days = hours / 24;

        String uploadTime = "";
        if (days >= 1) {
            uploadTime = days + "일 전";
        } else if (hours >= 1) {
            uploadTime = hours + "시간 전";
        } else if (minutes >= 1) {
            uploadTime = minutes + "분 전";
        } else {
            uploadTime = "방금 전";
        }

        boolean heart = getCommentHeartDAOBean.exec(commentDAO.getCommentId(), userId) != null;


        return ResponseCommentGetDTO.builder()
                .commentId(commentDAO.getCommentId())
                .userId(commentDAO.getUserId())
                .nickName(userDAO.getNickName())
                .imageUrl(userDAO.getImageUrl())
                .content(commentDAO.getContent())
                .heartCount(commentDAO.getHeartCount())
                .heart(heart)
                .uploadTime(uploadTime)
                .build();
    }


    public List<ResponseCommentGetDTO> exec(Long userId, List<CommentDAO> commentDAOS){
        List<ResponseCommentGetDTO> responseCommentGetDTOS = new ArrayList<>();
        for (CommentDAO commentDAO : commentDAOS){
            responseCommentGetDTOS.add(exec(userId, commentDAO));
        }
        return responseCommentGetDTOS;
    }
}
