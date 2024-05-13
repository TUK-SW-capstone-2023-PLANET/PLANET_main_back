package com.capstone.planet.Model.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ResponsePostGetDTO {
    Long postId;
    Long userId;
    String nickName;
    String profileUrl;
    List<String> imageUrl;
    String title;
    String content;
    Integer heartCount;
    Integer commentCount;
    Integer viewCount;
    String uploadTime;
    boolean heart;
}
