package com.capstone.planet.Model.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseChatGetDTO {
    Long chatId;
    String content;
    String senderImage;
    String type;
    String uploadTime;
}
