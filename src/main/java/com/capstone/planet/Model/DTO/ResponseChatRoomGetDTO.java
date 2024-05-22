package com.capstone.planet.Model.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseChatRoomGetDTO {
    Long chatRoomId;
    Long partnerUserId;
    String partnerUserName;
    String partnerUserImage;
    String content;
    String uploadTime;
    boolean newType;
}
