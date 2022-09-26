package kbg.modu.moduproject.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatRoom {
    
    //채팅방 식별자
    private Integer crSeq;
    //채팅방 고유 이름
    private String roomId;
    //채팅방 이름
    private String roomName;
    //교수 이름
    private String professorName;
    private String userWriterName;
    //제안서 번호
    private Integer pcSeq;
    private String addDate;
    private int userCount;

    public static ChatRoom create(String name) {
        ChatRoom room = new ChatRoom();
        room.roomId = UUID.randomUUID().toString();
        room.roomName = name;
        return room;
    }
}
