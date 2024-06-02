package com.capstone.planet.Controller;

import com.capstone.planet.Model.DTO.ResponseChatRoomGetDTO;
import com.capstone.planet.Model.DTO.ResponsePostsGetDTO;
import com.capstone.planet.Service.SearchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Search", description = "검색 관련 API")
@RestController
@CrossOrigin("*")
@RequestMapping("/search")
public class SearchController {

    SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    // 게시물
    @Operation(summary = "게시물 검색", description = "게시물 검색 두가지 경우가 존재. /search/post/free : 자유게시판, /search/post/{대학교 이름} : 대학게시판, /search/post/ : 에러 처리")
    @GetMapping("/post/{type}")
    public List<ResponsePostsGetDTO> getSearchPosts(@PathVariable String type, @RequestParam String search){
        return searchService.getSearchPosts(type, search);
    }

    // 쪽지함 검색
    @Operation(summary = "쪽지함 검색", description = "쪽지함 검색")
    @GetMapping("/chat/user/{userId}")
    public List<ResponseChatRoomGetDTO> getChatSearch(@PathVariable Long userId, @RequestParam String search){
        return searchService.getSearchChatRooms(userId, search);
    }
}