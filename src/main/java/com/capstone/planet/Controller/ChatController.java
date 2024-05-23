package com.capstone.planet.Controller;

import com.capstone.planet.Model.DTO.RequestChatRoomDeleteDTO;
import com.capstone.planet.Model.DTO.RequestChatSaveDTO;
import com.capstone.planet.Model.DTO.ResponseChatGetDTO;
import com.capstone.planet.Model.DTO.ResponseChatRoomGetDTO;
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
    public ResponseEntity<Map<String, Object>> getChats(@PathVariable Long chatRoomId, @PathVariable Long userId) {

        List<ResponseChatGetDTO> chats = chatService.getChats(chatRoomId, userId);

        // HTTP 상태 변환

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (chats.isEmpty()) ? "상대방이 쪽지함을 삭제함" : "쪽지 전체 조회 성공");
        requestMap.put("chats", chats);

        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 채팅방 전체 조회
    @Operation(summary = "채팅방 전체 조회", description = "채팅방 전체 조회")
    @GetMapping("/chat/chat-room/user/{userId}")
    public List<ResponseChatRoomGetDTO> getChatRooms(@PathVariable Long userId) {
        return chatService.getChatRooms(userId);
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

    // 채팅방 삭제
    @Operation(summary = "채팅방 삭제", description = "채팅방 삭제")
    @DeleteMapping("/chat/chat-room")
    public ResponseEntity<Map<String, Object>> deleteChatRoom(@RequestBody RequestChatRoomDeleteDTO requestChatRoomDeleteDTO) {
        Long chatRoomId = chatService.deleteChatRoom(requestChatRoomDeleteDTO);

        // HTTP 상태 반환
        HttpStatus httpStatus = (chatRoomId != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (chatRoomId != null) ? "채팅방 삭제 성공" : "채팅방 삭제 실패");
        requestMap.put("chatId", chatRoomId);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }

}
