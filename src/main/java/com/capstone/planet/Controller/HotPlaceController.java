package com.capstone.planet.Controller;

import com.capstone.planet.Model.DTO.ResponseHotPlaceGetDTO;
import com.capstone.planet.Service.HotPlaceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Hot Place", description = "핫플레이스")
@RestController
@CrossOrigin("*")
public class HotPlaceController {

    HotPlaceService hotPlaceService;

    @Autowired
    public HotPlaceController(HotPlaceService hotPlaceService) {
        this.hotPlaceService = hotPlaceService;
    }

    // 핫플레이스 조회
    @Operation(summary = "핫플레이스 조회", description = "핫플레이스 조회")
    @GetMapping("/hot-place")
    public List<ResponseHotPlaceGetDTO> getHotPlace(){
        return hotPlaceService.getHotPlace();
    }
}
