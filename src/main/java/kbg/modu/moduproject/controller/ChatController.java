package kbg.modu.moduproject.controller;


import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import kbg.modu.moduproject.domain.ChatMessage;
import kbg.modu.moduproject.repo.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatController {

    @Autowired
    MemberRepository mr;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

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

    // js에서 stompClient.send("/modu/topic/ccr/1/2",{},{}) 보내면
    // 1번 사용자가 2번 전문가에게 다이렉트로 메세지를 보낸것임
    @MessageMapping("/topic/ccr/{userSeq}/{expertSeq}")
    public void createChatRoom(SimpMessageHeaderAccessor headerAccessor
            ,@DestinationVariable String userSeq
            ,@DestinationVariable String expertSeq)
    {



        //TODO DB에서 채팅방이 미리 만들어져 있는지 확인해서 만들어져 있고
        //닫혀있지 않다면 기존 채팅방을 사용해야함
        //또한 해당 전문가의 seq가 정말로 존재하는지 검증하는 로직또한 필요함
        Gson gson = new Gson();
        String jsonStr = gson.toJson(ImmutableMap.of("questioner" , userSeq, "rgstDttm" , ""));

        simpMessagingTemplate.convertAndSend("/queue/" + expertSeq , jsonStr);
    }

}
