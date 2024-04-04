package com.capstone.planet.Controller;

import com.capstone.planet.Model.DTO.*;
import com.capstone.planet.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Tag(name = "User", description = "유저 기능 관련 API")
@RestController
@CrossOrigin("*")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 유저 정보조회
    @Operation(summary = "유저 정보 조회", description = "유저 핸들 아이디로 유저 정보 조회")
    @GetMapping("user/{userId}")
    public ResponseUserGetDTO getUser(@PathVariable Long userId){
        return userService.getUser(userId);
    }


    // 유저 랭킹 탑3 조회
    @Operation(summary = "유저 랭킹 탑3 조회", description = "유저 랭킹 탑3 조회")
    @GetMapping("user/rank")
    public List<ResponseUserRankGetDTO> getUserTop3(){
        return userService.getUserTop3();
    }

    // 유저 랭킹 전체조회
    @Operation(summary = "유저 랭킹 전체조회", description = "유저 랭킹 전체조회")
    @GetMapping("user/{userId}/rank/all")
    public List<Map<Integer, ResponseUserRanksGetDTO>> getUserAll(@PathVariable Long userId){
        return userService.getUserAll(userId);
    }

    // 대학교 소속 유저 탑3 랭킹 조회
    @Operation(summary = "대학교 소속 유저 탑3 랭킹 조회", description = "대학교 소속 유저 탑3 랭킹 조회")
    @GetMapping("user/{userId}/rank/university")
    public List<ResponseUserUniversityTop3GetDTO> getUniversityUserTop3(@PathVariable Long userId){
        return userService.getUniversityUserTop3(userId);
    }

    // 대학교 소속 유저 전체조회
    @Operation(summary = "대학교 소속 유저 전체조회", description = "대학교 소속 유저 전체조회")
    @GetMapping("user/{userId}/rank/university/all")
    public List<Map<Integer, ResponseUserUniversityGetDTO>> getUniversityUser(@PathVariable Long userId){
        return userService.getUniversityUser(userId);
    }

    // 유저 회원가입
    @Operation(summary = "유저 회원가입", description = "유저 회원가입 -> 추후 Oauth로 대체 예정")
    @PostMapping("user/join")
    public ResponseEntity<Map<String, Object>> saveUser(@RequestBody RequestUserSaveDTO requestUserSaveDTO){
        Long userHandleId = userService.saveUser(requestUserSaveDTO);

        // HTTP 상태 반환
        HttpStatus httpStatus = (userHandleId != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (userHandleId != null) ? "회원가입 성공" : "이미 존재하는 회원입니다.");
        requestMap.put("userHandleId", userHandleId);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }

    // 유저 정보 수정
    @Operation(summary = "유저 정보 수정", description = "마이페이지 수정 - 정보 하나만 바뀌더라도 전체 정보 받아야만 작동")
    @PutMapping("user")
    public ResponseEntity<Map<String, Object>> updateUser(@RequestBody RequestUserUpdateDTO requestUserUpdateDTO){
        Long userHandleId = userService.updateUser(requestUserUpdateDTO);

        // HTTP 상태 반환
        HttpStatus httpStatus = (userHandleId != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (userHandleId != null) ? "Update Success" : "Update Fail");
        requestMap.put("userHandleId", userHandleId);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }
}
