package kbg.modu.moduproject.controller.chat;


import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import kbg.modu.moduproject.domain.ChatMessage;
import kbg.modu.moduproject.domain.Member;
import kbg.modu.moduproject.domain.ProfessorCommission;
import kbg.modu.moduproject.repo.MemberRepository;
import kbg.modu.moduproject.repo.ProfessorCommissionRepository;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Controller
public class ChatController {

    @Autowired
    private MemberRepository mr;

    @Autowired
    private ProfessorCommissionRepository pc;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;



    int cnt;

    @RequestMapping("/MODUChatting")
    public String indexFrom() {
        return "/MODUChat";
    }

    @RequestMapping("/MODUChat")
    public String geMembers(ModelMap mm) {
        mm.put("members", mr.findAll());
        return "MODUChat";
    }


    @RequestMapping("/modu")
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage,
                               SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }

}