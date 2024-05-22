package com.capstone.planet.Model.DAO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserChatRoomDAO {
    @Id
    Long userChatRoomId;
    Long userId;
    Long chatRoomId;
    boolean newType;
}
