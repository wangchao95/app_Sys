package cn.appsys.controller.backend;

import cn.appsys.pojo.BackendUser;
import cn.appsys.service.BackendUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class BackLoginController {

    @Resource(name = "backendUserService")
    private BackendUserService backendUserService;

    /**
     * 登录方法
     * @param backendUser
     * @param httpSession
     * @return
     */
    @RequestMapping("/doBackLogin.html")
    @ResponseBody
    public Object login(BackendUser backendUser, HttpSession httpSession){
        BackendUser returnUser=backendUserService.BackLogin(backendUser);
        if(returnUser!=null){
            httpSession.setAttribute("backUser",returnUser);
            httpSession.setMaxInactiveInterval(600);  //设置会话时间
            return 1;
        }else{
            return 0;
        }
    }

    /**
     * 到主页
     * @return
     */
    @RequestMapping("/sysA/backmain.html")
    public String toMain(){
        return "backend/main";
    }

    /**
     * 退出
     * @param session
     * @return
     */
    @RequestMapping("/backloginOut.html")
    public String LoginOut(HttpSession session){
        session.invalidate();  //消除会话
        return "backend/backendlogin";
    }
}
