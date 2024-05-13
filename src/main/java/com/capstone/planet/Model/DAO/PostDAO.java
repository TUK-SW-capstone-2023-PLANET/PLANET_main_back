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
public class PostDAO {
    @Id
    Long postId;
    Long userId;
    String imageUrl;
    String title;
    String content;
    Integer heartCount;
    Integer commentCount;
    Integer viewCount;
    LocalDateTime uploadTime;
}
