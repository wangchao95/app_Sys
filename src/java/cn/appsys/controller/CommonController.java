package cn.appsys.controller;

import cn.appsys.service.DevUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class CommonController {

        @RequestMapping("/toDevLogin")
        public String toDevLogin(){
            return "developer/login";
        }

        @RequestMapping("/toBackLogin")
        public String toBackLogin(){
            return "backend/backendlogin";
        }

}
