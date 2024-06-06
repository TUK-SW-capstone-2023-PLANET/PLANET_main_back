package com.capstone.planet.Controller;

import com.capstone.planet.Model.DTO.*;
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
    @GetMapping("/post/{type}/user/{userId}")
    public List<ResponsePostsGetDTO> getSearchPosts(@PathVariable Long userId, @PathVariable String type, @RequestParam String search){
        return searchService.getSearchPosts(userId, type, search);
    }

    // 쪽지함 검색
    @Operation(summary = "쪽지함 검색", description = "쪽지함 검색")
    @GetMapping("/chat/user/{userId}")
    public List<ResponseChatRoomGetDTO> getChatSearch(@PathVariable Long userId, @RequestParam String search){
        return searchService.getSearchChatRooms(userId, search);
    }

    // 플래닛 랭킹 검색
    @Operation(summary = "플래닛 랭킹 검색", description = "플래닛 랭킹 검색")
    @GetMapping("/user/rank")
    public List<ResponseUserRanksGetDTO> getPlanetRankSearch(@RequestParam String search){
        return searchService.getSearchPlogging(search);
    }

    // 시즌 랭킹 검색
    @Operation(summary = "시즌 랭킹 검색", description = "시즌 랭킹 검색")
    @GetMapping("/season/rank")
    public List<ResponseSeasonUserGetDTO> getSeasonRankSearch(@RequestParam String search){
        return searchService.getSearchSeason(search);
    }

    // 대학교 랭킹 검색
    @Operation(summary = "대학교 랭킹 검색", description = "대학교 랭킹 검색")
    @GetMapping("/university/rank")
    public List<ResponseUniversityGetDTO> getUniversityRankSearch(@RequestParam String search){
        return searchService.getSearchUniversity(search);
    }

    // 대학교 유저 랭킹 검색
    @Operation(summary = "대학교 유저 랭킹 검색", description = "대학교 유저 랭킹 검색")
    @GetMapping("/university/rank/user/{userId}")
    public List<ResponseUserUniversityGetDTO> getUniversityUserRankSearch(@PathVariable Long userId, @RequestParam String search){
        return searchService.getSearchUniversityUser(userId, search);
    }

    // 내가 작성한 게시물 검색
    @Operation(summary = "내가 작성한 게시물 검색", description = "내가 작성한 게시물 검색 세가지 경우가 존재. /search/post/my/{userId}/all : 전체이자 기본으로 사용하면 좋을듯 /search/post/my/{userId}/free : 자유게시판, /search/post/my/{userId}/{userId} : 대학게시판, /search/post/my/{userId}/ : 에러 처리")
    @GetMapping("/post/my/{userId}/{type}")
    public List<ResponseMyPostGetDTO> getMyPostSearch(@PathVariable Long userId, @PathVariable String type, @RequestParam String search){
        return searchService.getSearchMyPost(userId, type, search);
    }

    // 내가 작성한 댓글 게시물 검색
    @Operation(summary = "내가 작성한 댓글 게시물 검색", description = "내가 작성한 댓글 게시물 검색 세가지 경우가 존재. /search/post/my/comment/{userId}/all : 전체이자 기본으로 사용하면 좋을듯 /search/post/my/comment/{userId}/free : 자유게시판, /search/post/my/comment/{userId}/{userId} : 대학게시판, /search/post/my/comment/{userId} : 에러 처리")
    @GetMapping("/post/my/comment/{userId}/{type}")
    public List<ResponseMyPostGetDTO> getMyCommentPostSearch(@PathVariable Long userId, @PathVariable String type, @RequestParam String search) {
        return searchService.getSearchMyCommentPost(userId, type, search);
    }

    // 지도 검색
    @Operation(summary = "지도 검색", description = "지도 검색")
    @GetMapping("/map/user/{userId}")
    public ResponseSearchMapGetDTO getMapSearch(@PathVariable Long userId, @RequestParam String search){
        return searchService.getSearchMap(userId, search);
    }

    // 게시물 검색 기록 유지
    @Operation(summary = "게시물 검색 기록", description = "게시물 검색 기록 5개로 유지")
    @GetMapping("/post/history/user/{userId}")
    public List<String> getPostHistory(@PathVariable Long userId){
        return searchService.getPostHistory(userId);
    }

    // 지도 검색 기록 유지  
    @Operation(summary = "지도 검색 기록", description = "지도 검색 기록 10개로 유지")
    @GetMapping("/map/history/user/{userId}")
    public List<String> getMapHistory(@PathVariable Long userId){
        return searchService.getMapHistory(userId);
    }
}