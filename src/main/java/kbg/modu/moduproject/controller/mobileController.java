package kbg.modu.moduproject.controller;

import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class mobileController {

    @RequestMapping("/mobile")
    public String device(Device device) {
        if (device.isMobile()) {
            return "Main";
        }  else {
            return "잘못된 접근 입니다.";
        }
    }
}
