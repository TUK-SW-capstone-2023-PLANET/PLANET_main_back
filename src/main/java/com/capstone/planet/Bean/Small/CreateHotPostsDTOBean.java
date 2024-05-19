package com.capstone.planet.Bean.Small;

import com.capstone.planet.Mapper.StringToListMapper;
import com.capstone.planet.Model.DAO.PostDAO;
import com.capstone.planet.Model.DAO.UserDAO;
import com.capstone.planet.Model.DTO.ResponseHotPostsGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class CreateHotPostsDTOBean {

    GetUserDAOBean getUserDAOBean;
    StringToListMapper stringToListMapper;

    @Autowired
    public CreateHotPostsDTOBean(GetUserDAOBean getUserDAOBean, StringToListMapper stringToListMapper) {
        this.getUserDAOBean = getUserDAOBean;
        this.stringToListMapper = stringToListMapper;
    }

    // 게시물 DTO 반환
    public ResponseHotPostsGetDTO exec(PostDAO postDAO){

        UserDAO userDAO = getUserDAOBean.exec(postDAO.getUserId());

        String uploadTime = postDAO.getUploadTime().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));

        List<String> imageUrl;

        if (postDAO.getImageUrl().equals("[]"))
            imageUrl = new ArrayList<>();
        else imageUrl = stringToListMapper.exec(postDAO.getImageUrl());

        return ResponseHotPostsGetDTO.builder()
                .postId(postDAO.getPostId())
                .userId(postDAO.getUserId())
                .title(postDAO.getTitle())
                .content(postDAO.getContent())
                .uploadTime(uploadTime)
                .nickName(userDAO.getNickName())
                .imageUrl(userDAO.getImageUrl())
                .heartCount(postDAO.getHeartCount())
                .commentCount(postDAO.getCommentCount())
                .viewCount(postDAO.getViewCount())
                .imageCount(imageUrl.size())
                .build();
    }

    public List<ResponseHotPostsGetDTO> exec(List<PostDAO> postDAOList){
        List<ResponseHotPostsGetDTO> responseHotPostsGetDTOS = new ArrayList<>();
        for (PostDAO postDAO : postDAOList) {
            responseHotPostsGetDTOS.add(exec(postDAO));
        }
        return responseHotPostsGetDTOS;
    }
}
