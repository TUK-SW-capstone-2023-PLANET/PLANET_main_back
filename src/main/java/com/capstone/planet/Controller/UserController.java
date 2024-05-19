package com.capstone.planet.Controller;

import com.capstone.planet.Model.DTO.*;
import com.capstone.planet.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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

    // 유저 id로 대학교 정보 가져오기
    @Operation(summary = "유저 id로 대학교 정보 가져오기", description = "유저 id로 대학교 정보 가져오기")
    @GetMapping("user/{userId}/university")
    public ResponseUniversityInfoGetDTO getUniversityInfo(@PathVariable Long userId){
        return userService.getUniversityInfo(userId);
    }

    // 유저 이름 중복 체크
    @Operation(summary = "유저 이름 중복 체크", description = "유저 이름 중복 체크")
    @GetMapping("user/name")
    public boolean checkUserName(@RequestParam String name){
        return userService.checkUserName(name);
    }

    // 유저 정보조회
    @Operation(summary = "유저 정보 조회", description = "유저 핸들 아이디로 유저 정보 조회")
    @GetMapping("user/{userId}")
    public ResponseUserGetDTO getUser(@PathVariable Long userId){
        return userService.getUser(userId);
    }

    // 유저 정보 저장
    @Operation(summary = "유저 정보 회원가입", description = "유저 회원가입시 정보 입력관련 저장")
    @PostMapping("user")
    public ResponseEntity<Map<String, Object>> saveUser(@RequestBody RequestUserProfileSaveDTO requestUserProfileSaveDTO){
        Long userId = userService.saveUserProfile(requestUserProfileSaveDTO);

        // HTTP 상태 반환
        HttpStatus httpStatus = (userId != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (userId != null) ? "Save Success" : "Save Fail");
        requestMap.put("userId", userId);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }


    // 유저 정보 수정
    @Operation(summary = "유저 정보 수정", description = "마이페이지 수정 - 이메일 제외 나머지 정보 전부 보내줌")
    @PutMapping("user")
    public ResponseEntity<Map<String, Object>> updateUser(@RequestBody RequestUserUpdateDTO requestUserUpdateDTO){
        Long userId = userService.updateUser(requestUserUpdateDTO);

        // HTTP 상태 반환
        HttpStatus httpStatus = (userId != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (userId != null) ? "Update Success" : "Update Fail");
        requestMap.put("userId", userId);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }


    // 자신 랭킹 조회
    @Operation(summary = "자신 랭킹 조회", description = "자신 랭킹 조회")
    @GetMapping("user/{userId}/rank")
    public ResponseUserRanksGetDTO getMyRank(@PathVariable Long userId){
        return userService.getMyRank(userId);
    }

    // 유저 랭킹 탑3 조회
    @Operation(summary = "유저 랭킹 탑3 조회", description = "유저 랭킹 탑3 조회")
    @GetMapping("user/rank")
    public List<ResponseUserRankGetDTO> getUserTop3(){
        return userService.getUserTop3();
    }

    // 유저 랭킹 전체조회
    @Operation(summary = "유저 랭킹 전체조회", description = "유저 랭킹 전체조회")
    @GetMapping("user/rank/all")
    public Page<ResponseUserRanksGetDTO> getUserAll(@PageableDefault(size=20, sort="score", direction = Sort.Direction.DESC) Pageable pageable){
        return userService.getUserAll(pageable);
    }




    // 자신 대학교 랭킹 조회
    @Operation(summary = "자신 대학교 랭킹 조회", description = "자신 대학교 랭킹 조회")
    @GetMapping("user/{userId}/rank/university")
    public ResponseUserUniversityGetDTO getMyUniversityRank(@PathVariable Long userId){
        return userService.getMyUniversityRank(userId);
    }

    // 대학교 소속 유저 4개 전체조회
    @Operation(summary = "대학교 소속 유저 4개 조회", description = "대학교 소속 유저 4개 전체조회")
    @GetMapping("user/{userId}/rank/university/4")
    public List<Map<Integer, ResponseUserUniversity4GetDTO>> getUniversity4User(@PathVariable Long userId){
        return userService.getUniversity4User(userId);
    }

    // 대학교 소속 유저 전체조회
    @Operation(summary = "대학교 소속 유저 전체조회", description = "대학교 소속 유저 전체조회")
    @GetMapping("user/{userId}/rank/all/university")
    public Page<ResponseUserUniversityGetDTO> getUniversityUser(@PathVariable("userId") Long userId,
                                                                @PageableDefault(size=20, sort="score", direction = Sort.Direction.DESC) Pageable pageable){
        return userService.getUniversityUser(userId, pageable);
    }
}
