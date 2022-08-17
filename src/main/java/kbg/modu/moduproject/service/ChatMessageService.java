package kbg.modu.moduproject.service;

import kbg.modu.moduproject.domain.ChatMessage;
import kbg.modu.moduproject.domain.Member;
import kbg.modu.moduproject.repo.ChatMessageRepository;
import kbg.modu.moduproject.repo.ProfessorCommissionRepository;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class ChatMessageService {

    @Autowired
    ChatMessageRepository cr;

    @Autowired
    ProfessorCommissionRepository pr;

    @Transactional
    public void saveMessage(ChatMessage message, int pcSeq){
        Member m = pr.findByMemberSeq(message.getSender());
        message = ChatMessage.builder()
                .sender(message.getSender())
                .message(message.getMessage())
                .roomId(message.getRoomId())
                .memberSeq(m.getSeq())
                .pcSeq(pcSeq)
                .build();
        cr.save(message);

    }

}
