package kbg.modu.moduproject.controller;


import kbg.modu.moduproject.domain.ProfessorCommission;
import kbg.modu.moduproject.service.ProfessorCommissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfessorCommissionController {

    @Autowired
    private ProfessorCommissionService ps;

    @RequestMapping(value="commission/Form", method = RequestMethod.GET)
    public String commissionForm(ProfessorCommission pc){
        return "commission/Form";
    }

    @RequestMapping(value="commission/Form", method = RequestMethod.POST)
    public String save(ProfessorCommission pc){
        ps.save(pc);
        return "redirect:/commission/list?=" + pc.getCategory();
    }

    @RequestMapping(value="commission/List", method = RequestMethod.POST)
    public String commissionList(@RequestParam String category, ModelMap mm){
        mm.put("list", ps.findByCategory(category));
        return "commission/List";
    }


}
