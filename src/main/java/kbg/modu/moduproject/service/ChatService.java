package kbg.modu.moduproject.service;


import kbg.modu.moduproject.domain.ChatRoom;
import kbg.modu.moduproject.domain.ProfessorCommission;
import kbg.modu.moduproject.repo.ChatRoomRepository;
import kbg.modu.moduproject.repo.ProfessorCommissionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChatService {

    @Autowired
    ProfessorCommissionRepository professorCommissionRepository;

    @Autowired
    ChatRoomRepository chatRoomRepository;

    private Map<String, ChatRoom> chatRooms;

    @PostConstruct
    //의존관게 주입완료되면 실행되는 코드
    private void init() {
        chatRooms = new LinkedHashMap<>();
    }

    //채팅방 불러오기
    public List<ChatRoom> findAllRoom() {
        //채팅방 최근 생성 순으로 반환
        List<ChatRoom> result = new ArrayList<>(chatRooms.values());
        Collections.reverse(result);

        return result;
    }

    //채팅방 하나 불러오기
    public ChatRoom findById(String roomId) {
        return chatRooms.get(roomId);
    }

    //채팅방 생성
    public ChatRoom createRoom(String name, int pcSeq, String userWriterName) {
        ChatRoom chatRoom = ChatRoom.create(name);
        chatRooms.put(chatRoom.getRoomId(), chatRoom);
        System.out.println(chatRoom.getUserWriterName()+"넌 뭐가나옴?");
        ProfessorCommission p = professorCommissionRepository.findBySeq(pcSeq);
        chatRoom = ChatRoom.builder()
                .roomName(chatRoom.getRoomName())
                .roomId(chatRoom.getRoomId())
                .professorName(p.getWriter())
                .userWriterName(userWriterName)
                .pcSeq(pcSeq)
                .build();
        chatRoomRepository.save(chatRoom);
        return chatRoom;
    }

}
