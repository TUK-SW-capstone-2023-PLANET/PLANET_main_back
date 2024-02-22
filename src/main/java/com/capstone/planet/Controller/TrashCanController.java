package com.capstone.planet.Controller;

import com.capstone.planet.Model.DTO.ResponseTrashCanGetDTO;
import com.capstone.planet.Service.TrashCanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Trash Can", description = "쓰레기통 관련 API")
@RestController
@CrossOrigin("*")
public class TrashCanController {

    TrashCanService userService;

    @Autowired
    public TrashCanController(TrashCanService userService) {
        this.userService = userService;
    }

    // 쓰레기통 조회
    @Operation(summary = "쓰레기통 정보 조회", description = "쓰레기통 아이디로 쓰레기통 정보 조회")
    @GetMapping("trash-can/{trashCanId}")
    public ResponseTrashCanGetDTO getUser(@PathVariable Long trashCanId){
        return userService.getTrashCan(trashCanId);
    }
}
