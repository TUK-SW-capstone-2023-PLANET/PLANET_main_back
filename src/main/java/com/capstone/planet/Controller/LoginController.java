package com.capstone.planet.Controller;

import com.capstone.planet.Model.DTO.RequestUserLoginDTO;
import com.capstone.planet.Service.LoginService;
import com.capstone.planet.Service.UserService;
import com.univcert.api.UnivCert;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@Tag(name = "Login", description = "로그인 관련 API")
@RestController
@CrossOrigin("*")
public class LoginController {

    UserService userService;
    LoginService loginService;

    @Autowired
    public LoginController(UserService userService, LoginService loginService) {
        this.userService = userService;
        this.loginService = loginService;
    }

    // 로그인 - 대학명 확인
    @Operation(summary = "로그인 - 대학명 확인", description = "대학명 입력시 대학명 확인")
    @GetMapping("/login/check")
    public ResponseEntity<Map<String, Object>> check(@RequestParam String name) throws IOException{

        if (name.equals("한국공학대학교")) name = "한국산업기술대학교";

        Map<String, Object> check = UnivCert.check(name);

        UnivCert.clear("1cc6fc5a-cf02-47a1-9b07-92a81b1f140c");

        return ResponseEntity.status(HttpStatus.OK).body(check);
    }

    // 로그인 - 이메일로 인증코드 전송
    @Operation(summary = "로그인 - 이메일로 인증코드 전송", description = "이메일, 학교명 입력시 인증코드 전송")
    @GetMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestParam String name, @RequestParam String email) throws IOException {

        int atIndex = email.indexOf("@");
        int dotIndex = email.indexOf(".");

        // "@" 이후의 문자열부터 "." 이전의 문자열까지 추출
        String newEmail = email.substring(atIndex + 1, dotIndex);

        if (name.equals("한국공학대학교")) name = "한국산업기술대학교";
        if (newEmail.equals("tukorea")) email = email.replace("tukorea", "kpu");

        Map<String, Object> certify = UnivCert.certify("1cc6fc5a-cf02-47a1-9b07-92a81b1f140c", email, name, true);

        return ResponseEntity.status(HttpStatus.OK).body(certify);
    }

    // 로그인 - 코드 입력
    @Operation(summary = "로그인 - 인증코드 인증", description = "인증코드 인증")
    @GetMapping("/login/code")
    public ResponseEntity<Map<String, Object>> loginCode(@RequestParam String name, @RequestParam String email, @RequestParam Integer code) throws IOException {

        int atIndex = email.indexOf("@");
        int dotIndex = email.indexOf(".");

        // "@" 이후의 문자열부터 "." 이전의 문자열까지 추출
        String newEmail = email.substring(atIndex + 1, dotIndex);

        if (name.equals("한국공학대학교")) name = "한국산업기술대학교";
        if (newEmail.equals("tukorea")) email = email.replace("tukorea", "kpu");

        Map<String, Object> certify = UnivCert.certifyCode("1cc6fc5a-cf02-47a1-9b07-92a81b1f140c", email, name, code);

        if (certify.get("success").equals(false)) {
            return ResponseEntity.status(HttpStatus.OK).body(certify);
        }

        Map<String, Object> map = userService.saveUser(certify);

        return ResponseEntity.status(HttpStatus.OK).body(map);
    }

    // 로그인
    @Operation(summary = "로그인", description = "로그인")
    @PostMapping("/login/user")
    public ResponseEntity<Map<String, Object>> login(@RequestBody RequestUserLoginDTO requestUserLoginDTO) {

        Map<String, Object> map = loginService.userLogin(requestUserLoginDTO);

        return ResponseEntity.status(HttpStatus.OK).body(map);
    }
}
