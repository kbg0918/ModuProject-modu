package kbg.modu.moduproject.repo;

import kbg.modu.moduproject.domain.ChatRoom;

import java.util.List;

public interface ChatRoomRepository {
    void save(ChatRoom chatRoom);
    List<ChatRoom> proCharRoomList(String writer);
    List<ChatRoom> stuChatRoomList(String writer);
    void delete(ChatRoom chatRoom);
    ChatRoom findByRoomId(String roomId);
}
