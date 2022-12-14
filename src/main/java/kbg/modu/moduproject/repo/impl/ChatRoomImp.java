package kbg.modu.moduproject.repo.impl;


import kbg.modu.moduproject.domain.ChatRoom;
import kbg.modu.moduproject.repo.ChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChatRoomImp implements ChatRoomRepository {

    @Autowired
    JdbcTemplate tp;

    @Override
    public void save(ChatRoom chatRoom) {
        tp.update("insert into chatting_room(room_name, room_id, professor_name, user_writer_name, pc_seq) values(?,?,?,?,?)",
                chatRoom.getRoomName(), chatRoom.getRoomId() ,chatRoom.getProfessorName(), chatRoom.getUserWriterName(), chatRoom.getPcSeq());
    }

    @Override
    public List<ChatRoom> proCharRoomList(String writer) {
        return tp.query("select * from chatting_room where professor_name = ?",
                new BeanPropertyRowMapper<>(ChatRoom.class), writer);
    }

    @Override
    public List<ChatRoom> stuChatRoomList(String writer) {
        return tp.query("select * from chatting_room where user_writer_name = ?",
                new BeanPropertyRowMapper<>(ChatRoom.class), writer);
    }

    @Override
    public void delete(ChatRoom chatRoom) {
        tp.update("update chatting_room set out_check=? where cr_seq = ?",
                chatRoom.getOutCheck(), chatRoom.getCrSeq());
    }

    @Override
    public ChatRoom findByRoomId(String roomId) {
        return tp.queryForObject("select * from chatting_room where room_id = ?",
                new BeanPropertyRowMapper<>(ChatRoom.class), roomId);
    }
}
