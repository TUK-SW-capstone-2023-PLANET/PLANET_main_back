package com.capstone.planet.Controller;

import com.capstone.planet.Model.DTO.ResponseAdvertisementGetDTO;
import com.capstone.planet.Service.AdvertisementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Advertisement", description = "관고 관련 API")
@RestController
@CrossOrigin("*")
public class AdvertisementController {

    AdvertisementService advertisementService;

    @Autowired
    public AdvertisementController(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    @Operation(summary = "광고 전체 조회", description = "상단 배너 광고 전체 조회")
    @GetMapping("/advertisement")
    public List<ResponseAdvertisementGetDTO> advertisement() {
        return advertisementService.getAdvertisement();
    }

}
