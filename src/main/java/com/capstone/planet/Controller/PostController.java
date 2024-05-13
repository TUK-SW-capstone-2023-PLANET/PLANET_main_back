package com.capstone.planet.Controller;

import com.capstone.planet.Model.DTO.RequestPostDeleteDTO;
import com.capstone.planet.Model.DTO.RequestPostSaveDTO;
import com.capstone.planet.Model.DTO.ResponsePostGetDTO;
import com.capstone.planet.Service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Tag(name = "Post", description = "게시물 관련 API")
@RestController
@CrossOrigin("*")
public class PostController {

    PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    // 게시물 조회
    @Operation(summary = "게시물 조회", description = "게시물 조회")
    @GetMapping("/post")
    public ResponsePostGetDTO getPost(@RequestParam Long postId, @RequestParam Long userId) {
        return postService.getPost(postId, userId);
    }

    // 게시물 저장
    @Operation(summary = "게시물 저장", description = "게시물 저장")
    @PostMapping("/post")
    public ResponseEntity<Map<String, Object>> savePost(@RequestBody RequestPostSaveDTO requestPostSaveDTO) {
        Long postId = postService.savePost(requestPostSaveDTO);

        // HTTP 상태 변환
        HttpStatus httpStatus = (postId == null) ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.OK;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (postId == null) ? "게시물 저장 실패" : "게시물 저장 성공");
        requestMap.put("postId", postId);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }

    // 게시물 삭제
    @Operation(summary = "게시물 삭제", description = "게시물 삭제")
    @DeleteMapping("/post")
    public ResponseEntity<Map<String, Object>> deletePost(@RequestBody RequestPostDeleteDTO requestPostDeleteDTO) {
        Long deletePostId = postService.deletePost(requestPostDeleteDTO);

        // HTTP 상태 변환
        HttpStatus httpStatus = (deletePostId == null) ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.OK;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (deletePostId == null) ? "게시물 삭제 실패" : "게시물 삭제 성공");
        requestMap.put("postId", deletePostId);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }
}
