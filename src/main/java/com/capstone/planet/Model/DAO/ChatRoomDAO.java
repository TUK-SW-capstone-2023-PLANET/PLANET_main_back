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
public class ChatRoomDAO {
    @Id
    Long chatRoomId;
    Long userOneId;
    Long userTwoId;
    String content;
    LocalDateTime contentUploadTime;

    @CreationTimestamp
    LocalDateTime uploadTime;
}
