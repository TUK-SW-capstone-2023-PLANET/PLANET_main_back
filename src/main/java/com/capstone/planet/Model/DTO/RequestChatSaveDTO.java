package com.capstone.planet.Model.DTO;

import lombok.Data;

@Data
public class RequestChatSaveDTO {
    Long senderId;
    Long receiverId;
    String content;
}
