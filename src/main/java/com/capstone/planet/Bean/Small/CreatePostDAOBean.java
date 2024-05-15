package com.capstone.planet.Bean.Small;

import com.capstone.planet.Mapper.ListToStringMapper;
import com.capstone.planet.Model.DAO.PostDAO;
import com.capstone.planet.Model.DTO.RequestPostSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CreatePostDAOBean {

    ListToStringMapper listToStringMapper;

    @Autowired
    public CreatePostDAOBean(ListToStringMapper listToStringMapper) {
        this.listToStringMapper = listToStringMapper;
    }

    // 게시물 DAO 생성
    public PostDAO exec(Long postId, RequestPostSaveDTO requestPostSaveDTO) {

        String imageUrl = listToStringMapper.exec(requestPostSaveDTO.getImageUrl());

        return PostDAO.builder()
                .postId(postId)
                .userId(requestPostSaveDTO.getUserId())
                .imageUrl(imageUrl)
                .title(requestPostSaveDTO.getTitle())
                .content(requestPostSaveDTO.getContent())
                .heartCount(0)
                .commentCount(0)
                .viewCount(0)
                .uploadTime(LocalDateTime.now().plusHours(9))
                .build();
    }
}
