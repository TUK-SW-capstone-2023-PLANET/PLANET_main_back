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

    // 시즌 유저 탑3 조회
    @Operation(summary = "시즌 유저 탑3 조회", description = "시즌 유저 탑3 조회")
    @GetMapping("/season/rank")
    public List<ResponseSeasonUserGetDTO> getSeasonTop3(){
        return seasonService.getSeasonTop3();
    }

    // 시즌 유저 전체 조회
    @Operation(summary = "시즌 유저 전체 조회", description = "시즌 유저 전체 조회")
    @GetMapping("/season/rank/all/user/{userId}")
    public Page<Map<Integer, ResponseSeasonUserGetDTO>> getSeasons(@PathVariable Long userId, @PageableDefault(size=20, sort="score", direction = Sort.Direction.DESC) Pageable pageable){
        return seasonService.getSeasonUsers(userId, pageable);
    }

    // 시즌 유저 5개 조회
    @Operation(summary = "시즌 유저 전체 조회", description = "시즌 유저 전체 조회")
    @GetMapping("/season/rank/5/user/{userId}")
    public List<Map<Integer, ResponseSeasonUserGetDTO>> getSeasons5(@PathVariable Long userId){
        return seasonService.getSeason5Users(userId);
    }
}
