package com.capstone.planet.Controller;

import com.capstone.planet.Model.DTO.ResponseUniversityGetDTO;
import com.capstone.planet.Service.UniversityService;
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

@Tag(name = "University", description = "대학 관련 API")
@RestController
@CrossOrigin("*")
public class UniversityController {

    UniversityService universityService;

    @Autowired
    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }


    @Operation(summary = "자기 대학 랭킹 조회", description = "자기 대학 랭킹 조회")
    @GetMapping("/university/rank/user/{userId}")
    public ResponseUniversityGetDTO university(@PathVariable("userId") Long userId) {
        return universityService.getUniversity(userId);
    }

    @Operation(summary = "대학 랭킹 3개 조회", description = "대학 랭킹 3개 조회")
    @GetMapping("/university/rank")
    public List<ResponseUniversityGetDTO> university() {
        return universityService.getUniversityTop3();
    }

    @Operation(summary = "대학 랭킹 전체 조회", description = "대학 랭킹 전체 조회")
    @GetMapping("/university/rank/all")
    public Page<ResponseUniversityGetDTO> universityAll(@PageableDefault(size=20, sort="score", direction = Sort.Direction.DESC) Pageable pageable){
        return universityService.getUniversitys(pageable);
    }

}
