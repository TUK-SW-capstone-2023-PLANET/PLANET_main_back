package com.capstone.planet.Bean.Small;

import com.capstone.planet.Mapper.StringToListMapper;
import com.capstone.planet.Model.DAO.PostDAO;
import com.capstone.planet.Model.DAO.UserDAO;
import com.capstone.planet.Model.DTO.ResponsePostGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreatePostDTOBean {

    StringToListMapper stringToListMapper;

    @Autowired
    public CreatePostDTOBean(StringToListMapper stringToListMapper) {
        this.stringToListMapper = stringToListMapper;
    }

    public ResponsePostGetDTO exec(PostDAO postDAO, UserDAO userDAO, boolean heart){

        List<String> imageUrl;

        if (postDAO.getImageUrl().equals("[]"))
            imageUrl = new ArrayList<>();
         else imageUrl = stringToListMapper.exec(postDAO.getImageUrl());

        String type;
        if (postDAO.getType().equals("free"))
            type = "자유 게시판";
        else type = "대학교 게시판";

        return ResponsePostGetDTO.builder()
                .postId(postDAO.getPostId())
                .userId(postDAO.getUserId())
                .nickName(userDAO.getNickName())
                .profileUrl(userDAO.getImageUrl())
                .imageUrl(imageUrl)
                .title(postDAO.getTitle())
                .content(postDAO.getContent())
                .heartCount(postDAO.getHeartCount())
                .commentCount(postDAO.getCommentCount())
                .viewCount(postDAO.getViewCount())
                .uploadTime(postDAO.getUploadTime().toString())
                .heart(heart)
                .type(type)
                .build();
    }
}
