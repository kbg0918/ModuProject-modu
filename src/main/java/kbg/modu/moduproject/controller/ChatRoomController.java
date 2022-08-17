package kbg.modu.moduproject.controller;

import kbg.modu.moduproject.domain.ChatMessage;
import kbg.modu.moduproject.domain.ChatRoom;
import kbg.modu.moduproject.domain.Member;
import kbg.modu.moduproject.domain.ProfessorCommission;
import kbg.modu.moduproject.repo.ProfessorCommissionRepository;
import kbg.modu.moduproject.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatRoomController {
    private final ChatService chatService;
    private int cnt=1;
    HashMap<String, Integer> m1 = new HashMap<>();

    @Autowired
    ProfessorCommissionRepository professorCommissionRepository;

    
    // 채팅 리스트 화면
    @GetMapping("/room")
    public String rooms(ChatRoom room) {
        return "/chat/room";
    }

    // 모든 채팅방 목록 반환
    @GetMapping("/rooms")
    @ResponseBody
    public List<ChatRoom> room() {
        return chatService.findAllRoom();
    }

    // 채팅방 생성
    @PostMapping("/room/{pcSeq}")
    @ResponseBody
    public ChatRoom createRoom(@RequestParam String name, @PathVariable String pcSeq, ChatRoom room) {
        chatService.save(room, name, Integer.parseInt(pcSeq));
        cnt=1;
        return chatService.createRoom(name);
    }

    // 채팅방 입장 화면
    @GetMapping("/room/enter/{roomId}")
    public String roomDetail(Model model, @DestinationVariable String roomId, ChatRoom room) {


        //방에 따른 인원수 제한
        if(m1.get(roomId) == null || m1.get(roomId) == cnt-1){
            room.setUserCount(cnt++);
        }
        else{
            room.setUserCount(m1.get(roomId));
        }


        m1.put(roomId, room.getUserCount());
        model.addAttribute("roomId", roomId);
        model.addAttribute("userCount", room.getUserCount());
        return "/chat/roomDetail";
    }
    // 특정 채팅방 조회
    @GetMapping("/room/{roomId}")
    @ResponseBody
    public ChatRoom roomInfo(@PathVariable String roomId) {
        return chatService.findById(roomId);
    }
}
