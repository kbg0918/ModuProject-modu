package kbg.modu.moduproject.repo.impl;

import kbg.modu.moduproject.domain.ChatMessage;
import kbg.modu.moduproject.repo.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class ChatMessageImp implements ChatMessageRepository {

    @Autowired
    JdbcTemplate tp;
    @Override
    public void save(ChatMessage message) {
        tp.update("insert into chatting_log(sender, message, room_id, member_seq, pc_seq) values(?,?,?,?,?)",
                message.getSender(), message.getMessage(), message.getRoomId(), message.getMemberSeq(), message.getPcSeq());

    }
}
