package com.capstone.planet.Controller;

import com.capstone.planet.Model.DTO.RequestUserDTO;
import com.capstone.planet.Model.DTO.ResponseUserDTO;
import com.capstone.planet.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 유저 정보조회
    @GetMapping("user/{userHandleId}")
    public ResponseUserDTO getUser(@PathVariable Long userHandleId){
        return userService.getUser(userHandleId);
    }

    // 유저 회원가입
    @PostMapping("user/join")
    public ResponseEntity<Map<String, Object>> saveUser(@RequestBody RequestUserDTO requestUserDTO){
        Long userHandleId = userService.saveUser(requestUserDTO);

        // HTTP 상태 반환
        HttpStatus httpStatus = (userHandleId != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (userHandleId != null) ? "회원가입 성공" : "이미 존재하는 회원입니다.");
        requestMap.put("userHandleId", userHandleId);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }
}
