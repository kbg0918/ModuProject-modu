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






    @RequestMapping(value="commission/Form", method = RequestMethod.GET)
    public String commissionForm(){
        return "commission/Form";
    }

    //제출하면 카테고리에 따라서 저장 form
    @RequestMapping(value = "commission/save", method = RequestMethod.POST)
    public String save(ProfessorCommission pc){
        pc.setMemberSeq(professorCommissionRepository.findByMemberSeq(pc.getWriter()).getSeq());
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
    public String update(ProfessorCommission pc, ModelMap mm, @PathVariable int pcSeq){
        mm.put("list", professorCommissionRepository.findBySeq(pcSeq));
        return "commission/Update";
    }
    
    //수정
    @RequestMapping(value="commission/update", method = RequestMethod.POST)
    public String commissionUpdate(ProfessorCommission pc){
        pc.setMemberSeq(professorCommissionRepository.findByMemberSeq(pc.getWriter()).getSeq());
        pc.setUpdateSeq(pc.getPcSeq());
        ps.save(pc);
        return "redirect:/commission/List?category="+pc.getCategory();
    }

    //게시물 리시트 보는 form
    @RequestMapping("commission/List")
    public String listForm(@RequestParam String category, ModelMap mm){
        mm.put("list", professorCommissionRepository.findByCategory(category));
        return "commission/List";
    }

    //게시물 찾는 form
    @RequestMapping("commission/Find")
    public String findForm(){
        return "commission/ProfessorFind";
    }

    @RequestMapping(value = "commission/ProFind/{category}", method = RequestMethod.GET)
    public String find(@PathVariable String category){
        return "redirect:/commission/List?category="+category;
    }

    //디테일 form
    @RequestMapping(value = "commission/detail", method = RequestMethod.GET)
    public String listDetail(@RequestParam int pcSeq, @RequestParam(required = false) String writer, ModelMap mm){
        mm.put("list", professorCommissionRepository.findBySeq(pcSeq));

        return "commission/detail";
    }

    @RequestMapping("/commission/notice")
    @ResponseBody
    public void commissionChatNotice(){
        System.out.println("commissionChatNotice");
    }

    @RequestMapping("/commission/review")
    @ResponseBody
    public void reviewNotice(){
        System.out.println("reviewNotice");
    }




}
