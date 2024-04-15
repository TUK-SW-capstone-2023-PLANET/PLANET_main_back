package com.capstone.planet.Controller;

import com.capstone.planet.Model.DTO.ResponseSeasonUserGetDTO;
import com.capstone.planet.Service.SeasonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Tag(name = "Season", description = "시즌 관련 API")
@RestController
@CrossOrigin("*")
public class SeasonController {

    SeasonService seasonService;

    @Autowired
    public SeasonController(SeasonService seasonService) {
        this.seasonService = seasonService;
    }

    // 시즌 유저 개인 랭킹 조회
    @Operation(summary = "시즌 유저 개인 랭킹 조회", description = "시즌 유저 개인 랭킹 조회")
    @GetMapping("/season/user/{userId}/rank")
    public ResponseSeasonUserGetDTO getSeason(@PathVariable Long userId){
        return seasonService.getSeason(userId);
    }

    // 시즌 유저 전체 조회
    @Operation(summary = "시즌 유저 전체 조회", description = "시즌 유저 전체 조회")
    @GetMapping("/season/rank/all")
    public Page<ResponseSeasonUserGetDTO> getSeasons(@PageableDefault(size=20, sort="score", direction = Sort.Direction.DESC) Pageable pageable){
        return seasonService.getSeasonUsers(pageable);
    }

    // 시즌 유저 5개 조회
    @Operation(summary = "시즌 유저 전체 조회", description = "시즌 유저 전체 조회")
    @GetMapping("/season/user/{userId}/rank/5")
    public List<Map<Integer, ResponseSeasonUserGetDTO>> getSeasons5(@PathVariable Long userId){
        return seasonService.getSeason5Users(userId);
    }
}
