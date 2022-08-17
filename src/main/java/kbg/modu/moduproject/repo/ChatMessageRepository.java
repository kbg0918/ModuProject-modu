package kbg.modu.moduproject.repo;


import kbg.modu.moduproject.domain.ChatMessage;

public interface ChatMessageRepository {
    void save(ChatMessage message);
}
