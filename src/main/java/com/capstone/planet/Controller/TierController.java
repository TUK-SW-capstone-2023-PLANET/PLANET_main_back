package com.capstone.planet.Controller;


import com.capstone.planet.Model.DTO.ResponseTierGetDTO;
import com.capstone.planet.Service.TierService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Tier", description = "티어 관련 API")
@RestController
@CrossOrigin("*")
public class TierController {

    TierService tierService;

    @Autowired
    public TierController(TierService tierService) {
        this.tierService = tierService;
    }

    // 티어 전체 조회
    @Operation(summary = "티어 전체 조회", description = "티어 전체 조회")
    @GetMapping("/tier")
    public List<ResponseTierGetDTO> getTiers(){
        return tierService.getTiers();
    }
}
