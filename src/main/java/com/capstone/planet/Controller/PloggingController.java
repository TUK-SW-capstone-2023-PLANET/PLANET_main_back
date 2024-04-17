package com.capstone.planet.Controller;

import com.capstone.planet.Model.DTO.RequestPloggingSaveDTO;
import com.capstone.planet.Model.DTO.ResponsePloggingStartDTO;
import com.capstone.planet.Service.PloggingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Tag(name = "Plogging", description = "플로깅 기록 관련 API")
@RestController
@CrossOrigin("*")
public class PloggingController {

    PloggingService ploggingService;

    @Autowired
    public PloggingController(PloggingService ploggingService) {
        this.ploggingService = ploggingService;
    }

    // 플로깅 시작시 플로깅 Id 생성
    @Operation(summary = "플로깅 아이디 생성", description = "플로깅 시작시 아이디 생성")
    @GetMapping("plogging/user/{userId}")
    public ResponsePloggingStartDTO getPloggingStart(@PathVariable Long userId){
        return ploggingService.getPloggingId(userId);
    }

    // 플로깅 저장
    @Operation(summary = "플로깅 저장", description = "플로깅 종료시 정보 받은 후 저장")
    @PostMapping("plogging")
    public ResponseEntity<Map<String, Object>> savePlogging(@RequestBody RequestPloggingSaveDTO requestPloggingSaveDTO) throws IOException {
        Long ploggingId = ploggingService.savePlogging(requestPloggingSaveDTO);

        // HTTP 상태 변환
        HttpStatus httpStatus = (ploggingId != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (ploggingId != null) ? "활동 저장 완료" : "활동 저장 실패");
        requestMap.put("ploggingId", ploggingId);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }
}
