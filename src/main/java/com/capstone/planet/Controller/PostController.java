package com.capstone.planet.Controller;

import com.capstone.planet.Model.DTO.*;
import com.capstone.planet.Service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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

    // 인기 게시물 조회
    @Operation(summary = "인기 게시물 조회", description = "인기 게시물 조회 두가지 경우가 존재. /post/hot/free : 자유게시판, /post/hot/{대학교 이름} : 대학게시판, /post/ : 에러 처리")
    @GetMapping("/post/hot/{type}")
    public ResponseHotPostGetDTO getHotPost(@PathVariable String type) {
        return postService.getHotPost(type);
    }

    // 조회수 기준 게시물 조회
    @Operation(summary = "조회수 기준 게시물 조회", description = "조회수 기준 게시물 조회 두가지 경우가 존재. /post/view/free : 자유게시판, /post/view/{대학교 이름} : 대학게시판, /post/view/ : 에러 처리")
    @GetMapping("/post/view/{type}")
    public ResponseViewPostGetDTO getViewPost(@PathVariable String type) {
        return postService.getViewPost(type);
    }

    // 게시물 전체 조회
    @Operation(summary = "게시물 전체 조회", description = "게시물 전체 조회지만 두가지 경우가 존재. /post/free : 자유게시판, /post/{대학교 이름} : 대학게시판, /post/ : 에러 처리")
    @GetMapping("/post/{type}")
    public List<ResponsePostsGetDTO> getPosts(@PathVariable String type) {
        return postService.getPosts(type);
    }

    // 인기 게시물 조회
    @Operation(summary = "인기 게시물 전체 조회", description = "인기 게시물 전체 조회")
    @GetMapping("/post/hot")
    public List<ResponseHotPostsGetDTO> getHotPosts() {
        return postService.getHotPosts();
    }

    // 내가 작성한 게시물 전체 조회
    @Operation(summary = "내가 작성한 게시물 전체 조회", description = "내가 작성한 게시물 전체 조회 세가지 경우가 존재. /post/my/{userId}/all : 전체이자 기본으로 사용하면 좋을듯 /post/my/{userId}/free : 자유게시판, /post/my/{userId}/{userId} : 대학게시판, /post/my/{userId}/ : 에러 처리")
    @GetMapping("/post/my/{userId}/{type}")
    public List<ResponseMyPostGetDTO> getMyPosts(@PathVariable String type, @PathVariable Long userId) {
        return postService.getMyPosts(type, userId);
    }

    // 내가 작성한 댓글 게시물 전체 조회
    @Operation(summary = "내가 작성한 댓글 게시물 전체 조회", description = "내가 작성한 댓글 게시물 전체 조회 세가지 경우가 존재. /post/my/comment/{userId}/all : 전체이자 기본으로 사용하면 좋을듯 /post/my/comment/{userId}/free : 자유게시판, /post/my/comment/{userId}/{userId} : 대학게시판, /post/my/comment/{userId} : 에러 처리")
    @GetMapping("/post/my/comment/{userId}/{type}")
    public List<ResponseMyPostGetDTO> getMyPostsComment(@PathVariable String type, @PathVariable Long userId) {
        return postService.getMyPostsComment(type, userId);
    }

    // 게시물 저장
    @Operation(summary = "게시물 저장", description = "게시물 저장이지만 두가지 경우가 존재. /post/free : 자유게시판, /post/university : 대학게시판, /post/ : 에러 처리")
    @PostMapping("/post/{type}")
    public ResponseEntity<Map<String, Object>> savePost(@PathVariable String type, @RequestBody RequestPostSaveDTO requestPostSaveDTO) {
        Long postId = postService.savePost(type, requestPostSaveDTO);

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
