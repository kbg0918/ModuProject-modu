package kbg.modu.moduproject.repo;

import kbg.modu.moduproject.domain.ChatRoom;

import java.util.List;

public interface ChatRoomRepository {
    void save(ChatRoom chatRoom);
    List<ChatRoom> charRoomList(String writer);
    ChatRoom findByRoomId(String roomId);
}
