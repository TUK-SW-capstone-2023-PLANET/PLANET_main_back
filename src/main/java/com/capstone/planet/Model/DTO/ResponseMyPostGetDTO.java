package com.capstone.planet.Model.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseMyPostGetDTO {
    Long postId;
    Long userId;
    String title;
    String content;
    String uploadTime;
    String nickName;
    Integer heartCount;
    Integer commentCount;
    Integer viewCount;
    Integer imageCount;
    String type;
}
