package com.capstone.planet.Controller;

import com.capstone.planet.Model.DTO.RequestCommentHeartSaveDTO;
import com.capstone.planet.Model.DTO.RequestPostHeartSaveDTO;
import com.capstone.planet.Service.CommentHeartService;
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

@Tag(name = "Comment", description = "댓글 관련 API")
@RestController
@CrossOrigin("*")
public class CommentHeartController {

    CommentHeartService commentHeartService;

    @Autowired
    public CommentHeartController(CommentHeartService commentHeartService) {
        this.commentHeartService = commentHeartService;
    }

    // 댓글 좋아요 저장
    @Operation(summary = "댓글 좋아요 저장", description = "댓글 좋아요 저장")
    @PostMapping("/comment-heart")
    public ResponseEntity<Map<String, Object>> saveCommentHeart(@RequestBody RequestCommentHeartSaveDTO requestCommentHeartSaveDTO) {
        Long commentId = commentHeartService.saveCommentHeart(requestCommentHeartSaveDTO);

        // HTTP 상태 변환
        HttpStatus httpStatus = (commentId == null) ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.OK;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (commentId == -1L) ? "댓글 좋아요 존재" : "댓글 좋아요 저장 성공");
        requestMap.put("commentId", commentId);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }
}
