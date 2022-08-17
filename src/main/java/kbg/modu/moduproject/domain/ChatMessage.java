package kbg.modu.moduproject.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatMessage {
    private MessageType type;
    private Integer clSeq;
    private String sender;
    //채팅방 Id
    private String roomId;
    //내용
    private String message;
    //유저 식별
    private Integer memberSeq;
    //게시물 번호
    private Integer pcSeq;

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE,
        ENTER,
        TALK
    }
}
