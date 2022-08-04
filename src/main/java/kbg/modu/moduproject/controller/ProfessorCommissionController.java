package kbg.modu.moduproject.controller;


import kbg.modu.moduproject.domain.Member;
import kbg.modu.moduproject.domain.ProfessorCommission;
import kbg.modu.moduproject.repo.ProfessorCommissionRepository;
import kbg.modu.moduproject.service.ProfessorCommissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
@Slf4j
public class ProfessorCommissionController {

    @Autowired
    private ProfessorCommissionService ps;

    @Autowired
    private ProfessorCommissionRepository pc;

    @RequestMapping(value="commission/Form", method = RequestMethod.GET)
    public String commissionForm(){
        return "commission/Form";
    }

    @RequestMapping(value = "commission/submit", method = RequestMethod.POST)
    public String save(ProfessorCommission pc){
        ps.save(pc);
        return "redirect:/commission/List?category="+pc.getCategory();
    }
    @RequestMapping("commission/List")
    public String testForm(@RequestParam String category, ModelMap mm){
        mm.put("list", ps.findByCategory(category));
        return "commission/List";
    }

    @RequestMapping("commission/Find")
    public String findForm(){
        return "commission/ProfessorFind";
    }

    @RequestMapping(value = "commission/ProFind", method = RequestMethod.POST)
    public String find(@RequestParam String category){

        return "redirect:/commission/List?category="+category;
    }

    @RequestMapping(value = "commission/detail", method = RequestMethod.GET)
    public String listDetail(@RequestParam int pcSeq, @RequestParam(required = false) String writer, ModelMap mm){
        mm.put("list", ps.findBySeq(pcSeq));
        Member member = pc.findByMemberSeq(writer);
        int exSeq = member.getSeq();
        mm.put("ex_seq", exSeq);
        return "commission/detail";
    }






}
