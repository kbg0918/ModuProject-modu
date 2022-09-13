package kbg.modu.moduproject.controller.chat;


import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import kbg.modu.moduproject.domain.Member;
import kbg.modu.moduproject.repo.ProfessorCommissionRepository;
import kbg.modu.moduproject.service.ProfessorCommissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.HashMap;

@Controller
public class StompNoticeController {

    @Autowired
    private ProfessorCommissionService ps;

    @Autowired
    private ProfessorCommissionRepository professorCommissionRepository;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    HashMap<String,String> map = new HashMap<>();
    HashMap<String,String> userSeqMap = new HashMap<>();


    @MessageMapping("/topic/ccr/{userSeq}/{exSeq}")
    @SendTo("topic/ccr/{userSeq}/{exSeq}")
    public void ChatStomp(Principal principal, SimpMessageHeaderAccessor headerAccessor
            , @DestinationVariable("userSeq") String userSeq
            , @DestinationVariable("exSeq") String exSeq) {


        //TODO DB에서 채팅방이 미리 만들어져 있는지 확인해서 만들어져 있고
        //닫혀있지 않다면 기존 채팅방을 사용해야함
        //또한 해당 전문가의 seq가 정말로 존재하는지 검증하는 로직또한 필요함
        Gson gson = new Gson();
        String jsonStr = gson.toJson(ImmutableMap.of("questioner" , userSeq, "rgstDttm" , ""));

        //교수
        simpMessagingTemplate.convertAndSend("/queue/" + exSeq , jsonStr);

        //학생
        simpMessagingTemplate.convertAndSend("/queue/" + userSeq , jsonStr);

    }

    //실시간 알림
    @MessageMapping("/notice/{pcSeq}/{userSeq}/{exSeq}")
    public void noticeStomp(@Header("simpSessionId") String sessionId , @RequestParam(required = false) String writer, SimpMessageHeaderAccessor sha , @DestinationVariable("pcSeq") String pcSeq, @DestinationVariable("userSeq") String userSeq
            , @DestinationVariable("exSeq") String exSeq){

        String msg = "";

        map.put(userSeq.toString(), sha.getUser().getName());
        System.out.println(map);

        Member member =  professorCommissionRepository.findByRole(Integer.parseInt(userSeq));
        userSeqMap.put(member.getMemberRole(), userSeq);


        if(map.size() >= 2){
            //보내는 곳
            if(member.getMemberRole().equals("Student")) { //교수한테 보내기
                System.out.println("교수한테 보내기");
                msg = "알림! 채팅방 요청" + sha.getUser().getName();
                simpMessagingTemplate.convertAndSendToUser(map.get(exSeq), "/queue/hello/"+pcSeq, msg);
            }

            if(member.getMemberRole().equals("Professor")){ //학생한테 보내기
                System.out.println("학생한테 보내기");
                msg = "알림! 교수의 수락" + sha.getUser().getName();
                simpMessagingTemplate.convertAndSendToUser(map.get(userSeqMap.get("Student")),"/queue/hello/"+pcSeq+"/"+userSeqMap.get("Student"), msg);
            }
        }
        else{
            System.out.println("null 입니다");
        }

    }
}
