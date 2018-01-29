package cn.appsys.controller.deve;

import cn.appsys.pojo.DevUser;
import cn.appsys.service.DevUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class DevLoginController {
    @Resource(name = "devUserService")
    private DevUserService devUserService;

//    /**
//     * 到登录页面
//     * @return
//     */
//    @RequestMapping("/login.html")
//    public String login(){
//        return "developer/login";
//    }

    @RequestMapping("/doLogin.html")
    @ResponseBody
    public Object doLogin(DevUser devUser, HttpSession httpSession){
        DevUser user=devUserService.findUser(devUser);
        int count=0;
        if(user!=null){
            httpSession.setAttribute("devUser", user);
            httpSession.setMaxInactiveInterval(600);
            count=1;
        }
        return count;
    }

    @RequestMapping("/sys/main.html")
    public String toMain(){
        return "developer/main";
    }

    /**
     * 退出
     * @return
     */
    @RequestMapping("/loginOut.html")
    public  String loginOut(HttpSession session){
        session.invalidate();
        return "developer/login";
    }
}
