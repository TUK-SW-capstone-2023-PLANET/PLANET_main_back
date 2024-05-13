package com.capstone.planet.Controller;

import com.capstone.planet.Model.DTO.RequestPostHeartDeleteDTO;
import com.capstone.planet.Model.DTO.RequestPostHeartSaveDTO;
import com.capstone.planet.Model.DTO.RequestPostSaveDTO;
import com.capstone.planet.Service.PostHeartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Tag(name = "Post Heart", description = "게시물 좋아요 관련 API")
@RestController
@CrossOrigin("*")
public class PostHeartController {

    PostHeartService postHeartService;

    @Autowired
    public PostHeartController(PostHeartService postHeartService) {
        this.postHeartService = postHeartService;
    }

    // 게시물 좋아요 저장
    @Operation(summary = "게시물 좋아요 저장", description = "게시물 좋아요 저장")
    @PostMapping("/post-heart")
    public ResponseEntity<Map<String, Object>> savePostHeart(@RequestBody RequestPostHeartSaveDTO requestPostHeartSaveDTO) {
        Long postId = postHeartService.savePostHeart(requestPostHeartSaveDTO);

        // HTTP 상태 변환
        HttpStatus httpStatus = (postId == null) ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.OK;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (postId == -1L) ? "게시물 좋아요 존재" : "게시물 좋아요 저장 성공");
        requestMap.put("postId", postId);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }

    // 게시물 좋아요 삭제
    @Operation(summary = "게시물 좋아요 삭제", description = "게시물 좋아요 삭제")
    @DeleteMapping("/post-heart")
    public ResponseEntity<Map<String, Object>> deletePostHeart(@RequestBody RequestPostHeartDeleteDTO requestPostHeartDeleteDTO) {
        Long postId = postHeartService.deletePostHeart(requestPostHeartDeleteDTO);

        // HTTP 상태 변환
        HttpStatus httpStatus = (postId == null) ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.OK;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (postId == -1L) ? "게시물 좋아요 미존재" : "게시물 좋아요 삭제 성공");
        requestMap.put("postId", postId);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }
}
