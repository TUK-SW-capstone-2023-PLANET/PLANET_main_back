package com.capstone.planet.Controller;

import com.capstone.planet.Model.DTO.RequestPostSaveDTO;
import com.capstone.planet.Service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    // 게시물 저장
    @Operation(summary = "게시물 저장", description = "플로깅 종료시 정보 받은 후 저장")
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
}
