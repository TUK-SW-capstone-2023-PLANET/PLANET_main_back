package com.capstone.planet.Controller;

import com.capstone.planet.Model.DTO.LiveTrashDTO;
import com.capstone.planet.Model.DTO.RequestPloggingLiveSaveDTO;
import com.capstone.planet.Service.PloggingLiveService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Tag(name = "Plogging Live", description = "플로깅 실시간 사진 관련 API")
@RestController
@CrossOrigin("*")
public class PloggingLiveController {

    PloggingLiveService ploggingService;

    @Autowired
    public PloggingLiveController(PloggingLiveService ploggingService) {
        this.ploggingService = ploggingService;
    }

    // 플로깅 실시간 사진 저장
    // AI 없어서 테스트로 만들어둠 추후 수정 필요
    @Operation(summary = "플로깅 실시간 사진 저장", description = "플로깅시 촬영한 사진 저장 및 쓰레기 갯수 반환")
    @PostMapping("plogging-live")
    public List<LiveTrashDTO> savePloggingLive(@RequestBody RequestPloggingLiveSaveDTO requestPloggingLiveSaveDTO){
        return ploggingService.savePloggingLiveDAO(requestPloggingLiveSaveDTO);

        /*// HTTP 상태 변환
        HttpStatus httpStatus = (ploggingId != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (ploggingId != null) ? "활동 저장 완료" : "활동 저장 실패");
        requestMap.put("ploggingId", ploggingId);

        return ResponseEntity.status(httpStatus).body(requestMap);*/
    }
}
