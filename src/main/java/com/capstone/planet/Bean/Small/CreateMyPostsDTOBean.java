package com.capstone.planet.Bean.Small;

import com.capstone.planet.Mapper.StringToListMapper;
import com.capstone.planet.Model.DAO.PostDAO;
import com.capstone.planet.Model.DAO.UserDAO;
import com.capstone.planet.Model.DTO.ResponseMyPostGetDTO;
import com.capstone.planet.Model.DTO.ResponsePostsGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class CreateMyPostsDTOBean {

    GetUserDAOBean getUserDAOBean;
    StringToListMapper stringToListMapper;

    @Autowired
    public CreateMyPostsDTOBean(GetUserDAOBean getUserDAOBean, StringToListMapper stringToListMapper) {
        this.getUserDAOBean = getUserDAOBean;
        this.stringToListMapper = stringToListMapper;
    }

    // 게시물 DTO 반환
    public ResponseMyPostGetDTO exec(PostDAO postDAO){

        UserDAO userDAO = getUserDAOBean.exec(postDAO.getUserId());

        LocalDateTime now = LocalDateTime.now().plusHours(9);
        LocalDateTime dateTime = postDAO.getUploadTime();
        String uploadTime = "";
        if (dateTime.toLocalDate().isEqual(now.toLocalDate())) {
            // 오늘인 경우
            uploadTime = dateTime.format(DateTimeFormatter.ofPattern("HH:mm"));
        } else {
            // 오늘 이전인 경우
            uploadTime = dateTime.format(DateTimeFormatter.ofPattern("MM-dd"));
        }

        String type;
        if (postDAO.getType().equals("free"))
            type = "자유 게시판";
        else type = "대학교 게시판";

        List<String> imageUrl;

        if (postDAO.getImageUrl().equals("[]"))
            imageUrl = new ArrayList<>();
        else imageUrl = stringToListMapper.exec(postDAO.getImageUrl());

        return ResponseMyPostGetDTO.builder()
                .postId(postDAO.getPostId())
                .userId(postDAO.getUserId())
                .title(postDAO.getTitle())
                .content(postDAO.getContent())
                .uploadTime(uploadTime)
                .nickName(userDAO.getNickName())
                .heartCount(postDAO.getHeartCount())
                .commentCount(postDAO.getCommentCount())
                .viewCount(postDAO.getViewCount())
                .imageCount(imageUrl.size())
                .type(type)
                .build();
    }

    public List<ResponseMyPostGetDTO> exec(List<PostDAO> postDAOList){
        List<ResponseMyPostGetDTO> responseMyPostGetDTOS = new ArrayList<>();
        for (PostDAO postDAO : postDAOList) {
            responseMyPostGetDTOS.add(exec(postDAO));
        }
        return responseMyPostGetDTOS;
    }
}
