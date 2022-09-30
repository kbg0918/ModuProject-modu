package kbg.modu.moduproject.controller.chat;

import kbg.modu.moduproject.domain.ChatMessage;
import kbg.modu.moduproject.domain.Member;
import kbg.modu.moduproject.service.ChatMessageService;
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

    @Autowired
    ChatMessageService cs;

    @MessageMapping("/room/message/{pcSeq}")
    public void chatSend(ChatMessage message, @DestinationVariable String pcSeq){
        if (ChatMessage.MessageType.ENTER.equals(message.getType())) {
            message.setMessage(message.getSender()+"님이 입장하였습니다.");
        }
        simpMessagingTemplate.convertAndSend("/queue/room/"+message.getRoomId(),message);
        cs.saveMessage(message, Integer.parseInt(pcSeq));
    }

    @MessageMapping("room/message/type/{pcSeq}")
    public void chatType(ChatMessage message, @DestinationVariable String pcSeq){
        if (ChatMessage.MessageType.ENTER.equals(message.getType())) {
            message.setMessage(message.getSender()+"님이 입장하였습니다.");
        }
        simpMessagingTemplate.convertAndSend("/queue/room/"+message.getRoomId(),message);
        cs.saveMessage(message, Integer.parseInt(pcSeq));
    }
}
