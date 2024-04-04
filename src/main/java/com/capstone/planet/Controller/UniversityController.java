package com.capstone.planet.Controller;

import com.capstone.planet.Model.DTO.ResponseUniversityGetDTO;
import com.capstone.planet.Service.UniversityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

    @Operation(summary = "대학 랭킹 3개 조회", description = "대학 랭킹 3개 조회")
    @GetMapping("/university")
    public List<ResponseUniversityGetDTO> university() {
        return universityService.getUniversityTop3();
    }

    @Operation(summary = "대학 랭킹 전체 조회", description = "대학 랭킹 전체 조회")
    @GetMapping("/university/all")
    public List<Map<Integer, ResponseUniversityGetDTO>> universityAll() {
        return universityService.getUniversitys();
    }

}
