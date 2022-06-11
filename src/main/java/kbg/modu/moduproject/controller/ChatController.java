package kbg.modu.moduproject.controller;


import kbg.modu.moduproject.domain.ChatMessage;
import kbg.modu.moduproject.repo.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatController {

    @Autowired
    MemberRepository mr;

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
