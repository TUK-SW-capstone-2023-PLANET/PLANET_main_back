package com.capstone.planet.Controller;

import com.capstone.planet.Model.DTO.ResponseSeasonUserGetDTO;
import com.capstone.planet.Service.SeasonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
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

    // 시즌 유저 전체 조회
    @Operation(summary = "시즌 유저 전체 조회", description = "시즌 유저 전체 조회")
    @GetMapping("/season/user/{userId}")
    public List<Map<Integer, ResponseSeasonUserGetDTO>> getSeasons(@PathVariable Long userId){
        return seasonService.getSeasonUsers(userId);
    }
}
