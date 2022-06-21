package kbg.modu.moduproject.controller;


import kbg.modu.moduproject.domain.ProfessorCommission;
import kbg.modu.moduproject.service.ProfessorCommissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(value="commission/Form", method = RequestMethod.GET)
    public String commissionForm(ProfessorCommission pc, HttpServletResponse response, HttpSession session){
        return "commission/Form";
    }

    @RequestMapping(value = "commission/submit", method = RequestMethod.POST)
    public String save(ProfessorCommission pc){
        ps.save(pc);

        try {
            String encode = URLEncoder.encode(pc.getCategory(), "UTF-8");
            return "redirect:/test?category="+ encode;
        } catch (Exception e) {
            e.getMessage();
            log.error("category null");
        }
        return "Main";
    }
    @RequestMapping("test")
    public String testForm(@RequestParam String category, ModelMap mm){
        mm.put("list", ps.findByCategory(category));
        return "test";
    }

    @RequestMapping(value="commission/List", method = RequestMethod.POST)
    public String commissionList(@RequestParam String category, ModelMap mm){
        mm.put("list", ps.findByCategory(category));
        return "commission/List";
    }




}
