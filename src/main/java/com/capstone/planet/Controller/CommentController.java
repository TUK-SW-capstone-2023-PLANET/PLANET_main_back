package com.capstone.planet.Controller;

import com.capstone.planet.Model.DTO.RequestCommentDeleteDTO;
import com.capstone.planet.Model.DTO.RequestCommentSaveDTO;
import com.capstone.planet.Model.DTO.RequestPostSaveDTO;
import com.capstone.planet.Model.DTO.ResponseCommentGetDTO;
import com.capstone.planet.Service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Tag(name = "Comment", description = "댓글 관련 API")
@RestController
@CrossOrigin("*")
public class CommentController {

    CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // 댓글 전체 조회
    @Operation(summary = "댓글 전체 조회", description = "게시물에 해당하는 댓글 전부 조회")
    @GetMapping("/comment")
    public List<ResponseCommentGetDTO> getComments(@RequestParam Long postId, @RequestParam Long userId) {
        return commentService.getComments(postId, userId);
    }

    // 댓글 저장
    @Operation(summary = "댓글 저장", description = "댓글 저장 후 commentId 반환")
    @PostMapping("/comment")
    public ResponseEntity<Map<String, Object>> saveComment(@RequestBody RequestCommentSaveDTO requestCommentSaveDTO) {
        Long commentId = commentService.saveComment(requestCommentSaveDTO);

        // HTTP 상태 변환
        HttpStatus httpStatus = (commentId == null) ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.OK;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (commentId == null) ? "댓글 저장 실패" : "댓글 저장 성공");
        requestMap.put("commentId", commentId);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }

    // 댓글 삭제
    @Operation(summary = "댓글 삭제", description = "댓글 삭제 후 commentId 반환")
    @DeleteMapping("/comment")
    public ResponseEntity<Map<String, Object>> deleteComment(@RequestBody RequestCommentDeleteDTO requestCommentDeleteDTO) {
        Long commentId = commentService.deleteComment(requestCommentDeleteDTO);

        // HTTP 상태 변환
        HttpStatus httpStatus = (commentId == null) ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.OK;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (commentId == null) ? "댓글 삭제 실패" : "댓글 삭제 성공");
        requestMap.put("commentId", commentId);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }
}
