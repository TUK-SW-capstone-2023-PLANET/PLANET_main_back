package com.capstone.planet.Model.DAO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ChatDAO {
    @Id
    Long chatId;
    Long chatRoomId;
    Long senderId;
    Long receiverId;
    String content;

    @CreationTimestamp
    LocalDateTime uploadTime;
}
