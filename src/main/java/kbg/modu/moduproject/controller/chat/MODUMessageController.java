package kbg.modu.moduproject.controller.chat;

import kbg.modu.moduproject.domain.ChatMessage;
import kbg.modu.moduproject.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MODUMessageController {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/room/message/{pcSeq}")
    public void chatSend(ChatMessage message, @DestinationVariable String pcSeq){
        System.out.println("들어오니 보자 한 번");
        simpMessagingTemplate.convertAndSend("/queue/room/"+message.getRoomId(),message);
        System.out.println(message.getRoomId());
    }
}
