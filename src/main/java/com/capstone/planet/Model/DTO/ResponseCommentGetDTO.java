package com.capstone.planet.Model.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseCommentGetDTO {
    Long commentId;
    Long userId;
    String nickName;
    String imageUrl;
    String content;
    Integer heartCount;
    boolean heart;
    String uploadTime;
}
