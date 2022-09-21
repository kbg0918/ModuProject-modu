package kbg.modu.moduproject.repo;

import kbg.modu.moduproject.domain.ChatRoom;

import java.util.List;

public interface ChatRoomRepository {
    void save(ChatRoom chatRoom);
    public List<ChatRoom> charRoomList(String writer);
}
