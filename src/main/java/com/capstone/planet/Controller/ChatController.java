package com.capstone.planet.Controller;

import com.capstone.planet.Model.DTO.RequestChatSaveDTO;
import com.capstone.planet.Model.DTO.ResponseChatGetDTO;
import com.capstone.planet.Service.ChatService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Tag(name = "Chat", description = "쪽지 관련 API")
@RestController
@CrossOrigin("*")
public class ChatController {

    ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    // 채팅방 채팅 내역 조회
    @Operation(summary = "채팅방 채팅 내역 전체 조회", description = "채팅방 채팅 내역 전체 조회")
    @GetMapping("/chat/chat-room/{chatRoomId}/user/{userId}")
    public List<ResponseChatGetDTO> getChats(@PathVariable Long chatRoomId, @PathVariable Long userId) {
        return chatService.getChats(chatRoomId, userId);
    }

    // 채팅 저장
    @Operation(summary = "쪽지 저장", description = "쪽지 저장 후 chatId 반환")
    @PostMapping("/chat")
    public ResponseEntity<Map<String, Object>> saveChat(@RequestBody RequestChatSaveDTO requestChatSaveDTO) {
        Long chatId = chatService.saveChat(requestChatSaveDTO);

        // HTTP 상태 변환
        HttpStatus httpStatus = (chatId == null) ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.OK;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (chatId == null) ? "쪽지 저장 실패" : "쪽지 저장 성공");
        requestMap.put("chatId", chatId);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }
}
