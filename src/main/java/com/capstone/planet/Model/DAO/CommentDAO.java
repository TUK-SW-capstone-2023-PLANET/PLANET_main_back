package com.capstone.planet.Model.DAO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CommentDAO {
    @Id
    Long commentId;
    Long postId;
    Long userId;
    String content;
    Integer heartCount;
    LocalDateTime uploadTime;
}
