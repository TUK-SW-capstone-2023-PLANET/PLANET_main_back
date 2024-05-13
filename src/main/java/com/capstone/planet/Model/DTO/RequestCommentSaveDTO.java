package com.capstone.planet.Model.DTO;

import lombok.Data;

@Data
public class RequestCommentSaveDTO {
    Long postId;
    Long userId;
    String content;
}
