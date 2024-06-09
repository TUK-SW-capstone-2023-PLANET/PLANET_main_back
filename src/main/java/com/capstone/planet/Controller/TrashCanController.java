package com.capstone.planet.Controller;

import com.capstone.planet.Model.DTO.RequestTrashCanSaveDTO;
import com.capstone.planet.Model.DTO.ResponseTrashCanAllGetDTO;
import com.capstone.planet.Model.DTO.ResponseTrashCanGetDTO;
import com.capstone.planet.Service.TrashCanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Tag(name = "Trash Can", description = "쓰레기통 관련 API")
@RestController
@CrossOrigin("*")
public class TrashCanController {

    TrashCanService trashCanService;

    @Autowired
    public TrashCanController(TrashCanService trashCanService) {
        this.trashCanService = trashCanService;
    }

    // 쓰레기통 조회
    @Operation(summary = "쓰레기통 정보 조회", description = "쓰레기통 아이디로 쓰레기통 정보 조회")
    @GetMapping("trash-can/{trashCanId}")
    public ResponseTrashCanGetDTO getUser(@PathVariable Long trashCanId){
        return trashCanService.getTrashCan(trashCanId);
    }

    // 쓰레기통 전체 조회
    @Operation(summary = "전체 쓰레기통 정보 조회", description = "전체 쓰레기통 정보 조회")
    @GetMapping("trash-can/all")
    public List<ResponseTrashCanAllGetDTO> getUserAllInfo(){
        return trashCanService.getTrashCanAll();
    }

    // 쓰레기통 저장
    @Operation(summary = "쓰레기통 저장", description = "쓰레기통 정보 저장")
    @PostMapping("trash-can")
    public ResponseEntity<Map<String, Object>> saveUser(@RequestBody RequestTrashCanSaveDTO requestTrashCanSaveDTO){

        Long trashCanId = trashCanService.saveTrashCan(requestTrashCanSaveDTO);

        // HTTP 상태 변환
        HttpStatus httpStatus = (trashCanId == null) ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.OK;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (trashCanId == null) ? "쓰레기통 저장 실패" : "쓰레기통 저장 성공");
        requestMap.put("trashCanId", trashCanId);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }

}
