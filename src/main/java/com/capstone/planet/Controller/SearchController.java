package com.capstone.planet.Controller;

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

    // 유저 검색
    @Operation(summary = "유저 검색", description = "유저 검색 두가지 경우가 존재. /search/post/free : 자유게시판, /search/post/{대학교 이름} : 대학게시판, /search/post/ : 에러 처리")
    @GetMapping("/post/{type}")
    public List<ResponsePostsGetDTO> getUserSearch(@PathVariable String type, @RequestParam String search){
        return searchService.getSearchPosts(type, search);
    }
}