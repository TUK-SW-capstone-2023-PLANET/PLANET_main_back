package com.capstone.planet.Bean.Small;

import com.capstone.planet.Mapper.StringToListMapper;
import com.capstone.planet.Model.DAO.PostDAO;
import com.capstone.planet.Model.DAO.UserDAO;
import com.capstone.planet.Model.DTO.ResponsePostsGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class CreatePostsDTOBean {

    GetUserDAOBean getUserDAOBean;
    StringToListMapper stringToListMapper;

    @Autowired
    public CreatePostsDTOBean(GetUserDAOBean getUserDAOBean, StringToListMapper stringToListMapper) {
        this.getUserDAOBean = getUserDAOBean;
        this.stringToListMapper = stringToListMapper;
    }

    // 게시물 DTO 반환
    public ResponsePostsGetDTO exec(PostDAO postDAO){

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

        List<String> imageUrl;

        if (postDAO.getImageUrl().equals("[]"))
            imageUrl = new ArrayList<>();
        else imageUrl = stringToListMapper.exec(postDAO.getImageUrl());

        return ResponsePostsGetDTO.builder()
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
                .build();
    }

    public List<ResponsePostsGetDTO> exec(List<PostDAO> postDAOList){
        List<ResponsePostsGetDTO> responsePostsGetDTOList = new ArrayList<>();
        for (PostDAO postDAO : postDAOList) {
            responsePostsGetDTOList.add(exec(postDAO));
        }
        return responsePostsGetDTOList;
    }
}
