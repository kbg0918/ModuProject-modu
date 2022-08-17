package kbg.modu.moduproject.controller;


import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import kbg.modu.moduproject.config.StompPrincipal;
import kbg.modu.moduproject.domain.ChatMessage;
import kbg.modu.moduproject.domain.Member;
import kbg.modu.moduproject.domain.ProfessorCommission;
import kbg.modu.moduproject.handler.UUIDHandler;
import kbg.modu.moduproject.repo.ProfessorCommissionRepository;
import kbg.modu.moduproject.service.ProfessorCommissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Controller
@Slf4j
public class ProfessorCommissionController {

    @Autowired
    private ProfessorCommissionService ps;

    @Autowired
    private ProfessorCommissionRepository professorCommissionRepository;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    HashMap<String,String> map = new HashMap<>();
    HashMap<String,String> userSeqMap = new HashMap<>();


    @RequestMapping(value="commission/Form", method = RequestMethod.GET)
    public String commissionForm(){
        return "commission/Form";
    }

    //제출하면 카테고리에 따라서 저장 form
    @RequestMapping(value = "commission/save", method = RequestMethod.POST)
    public String save(ProfessorCommission pc){
        ps.save(pc);
        return "redirect:/commission/List?category="+pc.getCategory();
    }

    //삭제
    @RequestMapping(value="commission/delete/{pcSeq}", method = RequestMethod.GET)
    public String delete(ProfessorCommission pc, @PathVariable("pcSeq") int pcSeq){
        pc.setPcSeq(pcSeq);
        ps.delete(pc);
        return "redirect:/MainForm";
    }
    
    //수정
    @RequestMapping(value="commission/updateForm/{pcSeq}")
    public String update(ProfessorCommission pc, ModelMap mm, @PathVariable String pcSeq){
        mm.put("list", ps.findBySeq(Integer.parseInt(pcSeq)));
        return "commission/Update";
    }
    
    //수정
    @RequestMapping(value="commission/update", method = RequestMethod.POST)
    public String commissionUpdate(ProfessorCommission pc){
        pc.setPcSeq(pc.getPcSeq());
        ps.save(pc);
        return "redirect:/commission/List?category="+pc.getCategory();
    }

    //게시물 리시트 보는 form
    @RequestMapping("commission/List")
    public String listForm(@RequestParam String category, ModelMap mm){
        mm.put("list", ps.findByCategory(category));
        return "commission/List";
    }

    //게시물 찾는 form
    @RequestMapping("commission/Find")
    public String findForm(){
        return "commission/ProfessorFind";
    }

    @RequestMapping(value = "commission/ProFind", method = RequestMethod.POST)
    public String find(@RequestParam String category){

        return "redirect:/commission/List?category="+category;
    }

    //디테일 form
    @RequestMapping(value = "commission/detail", method = RequestMethod.GET)
    public String listDetail(@RequestParam int pcSeq, @RequestParam(required = false) String writer, ModelMap mm){
        mm.put("list", ps.findBySeq(pcSeq));
        Member member = professorCommissionRepository.findByMemberSeq(writer);
        int exSeq = member.getSeq();
        mm.put("ex_seq", exSeq);


        return "commission/detail";
    }


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

    @MessageMapping("/notice/{pcSeq}/{userSeq}/{exSeq}")
    public void NoticeStomp(@RequestParam(required = false) String writer, SimpMessageHeaderAccessor sha , @DestinationVariable("pcSeq") String pcSeq, @DestinationVariable("userSeq") String userSeq
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
