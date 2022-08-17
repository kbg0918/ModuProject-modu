package kbg.modu.moduproject.repo.impl;


import kbg.modu.moduproject.domain.ChatRoom;
import kbg.modu.moduproject.repo.ChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ChatRoomImp implements ChatRoomRepository {

    @Autowired
    JdbcTemplate tp;

    @Override
    public void save(ChatRoom chatRoom) {
        tp.update("insert into chatting_room(room_name, professor_name, pc_seq) values(?,?,?)",
                chatRoom.getRoomName(), chatRoom.getProfessorName(), chatRoom.getPcSeq());
    }
}
