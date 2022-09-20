package kbg.modu.moduproject.controller.chat;


import kbg.modu.moduproject.domain.ChatRoom;
import kbg.modu.moduproject.repo.ProfessorCommissionRepository;
import kbg.modu.moduproject.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class MODUChatController {
    private final ChatService chatService;
    private int cnt=1;
    HashMap<String, Integer> m1 = new HashMap<>();

    @Autowired
    ProfessorCommissionRepository professorCommissionRepository;


    @RequestMapping("/test")
    public String test(){
        return "/chat/MODURoom";
    }

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
    @PostMapping("/room")
    @ResponseBody
    public ChatRoom createRoom(@RequestBody ChatRoom cr) {
        System.out.println(cr);
        return chatService.createRoom(cr.getRoomName(), cr.getPcSeq());
    }

    // 채팅방 입장 화면
    @GetMapping("/room/enter/{roomId}")
    public String roomDetail(Model model, @DestinationVariable String roomId, ChatRoom room) {
        //방에 따른 인원수 제한
        m1.put(roomId, room.getUserCount());
        model.addAttribute("roomId", roomId);
        return "/chat/roomDetail";
    }
    // 특정 채팅방 조회
    @GetMapping("/room/{roomId}")
    @ResponseBody
    public ChatRoom roomInfo(@PathVariable String roomId) {
        return chatService.findById(roomId);
    }
}
