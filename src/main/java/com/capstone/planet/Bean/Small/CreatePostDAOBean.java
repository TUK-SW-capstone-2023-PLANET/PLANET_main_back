package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.PostDAO;
import com.capstone.planet.Model.DTO.RequestPostSaveDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CreatePostDAOBean {

    // 게시물 DAO 생성
    public PostDAO exec(Long postId, RequestPostSaveDTO requestPostSaveDTO) {

        return PostDAO.builder()
                .postId(postId)
                .userId(requestPostSaveDTO.getUserId())
                .imageUrl(requestPostSaveDTO.getImageUrl())
                .title(requestPostSaveDTO.getTitle())
                .content(requestPostSaveDTO.getContent())
                .heartCount(0)
                .commentCount(0)
                .uploadTime(LocalDateTime.now())
                .build();
    }
}
