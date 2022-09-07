package kbg.modu.moduproject.controller.chat;

import kbg.modu.moduproject.domain.ChatMessage;
import kbg.modu.moduproject.domain.Member;
import kbg.modu.moduproject.repo.ChatMessageRepository;
import kbg.modu.moduproject.repo.ProfessorCommissionRepository;
import kbg.modu.moduproject.service.ChatMessageService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MessageController {

    @Autowired
    ChatMessageService cs;

    @Autowired
    ProfessorCommissionRepository pr;


    private final SimpMessageSendingOperations sendingOperations;
    @MessageMapping("/chat/message/{pcSeq}")
    public void enter(ChatMessage message, @DestinationVariable("pcSeq") int pcSeq, ModelMap mm) {
        Member m = pr.findByMemberSeq(message.getSender());
        if (ChatMessage.MessageType.ENTER.equals(message.getType())) {
            message.setMessage(message.getSender()+"님이 입장하였습니다.");
        }
        sendingOperations.convertAndSend("/topic/chat/room/"+message.getRoomId(),message);
        cs.saveMessage(message, pcSeq);

    }
}
