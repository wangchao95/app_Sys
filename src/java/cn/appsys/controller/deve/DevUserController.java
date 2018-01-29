package cn.appsys.controller.deve;

import cn.appsys.pojo.DevUser;
import cn.appsys.service.DevUserService;
import cn.appsys.tools.Message;
import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/sys/devUser")
public class DevUserController {
    @Resource(name = "devUserService")
    private DevUserService devUserService;

    /**
     * 到app列表页面
     * @return
     */
    @RequestMapping("/appList.html")
    public String toAppList(){
        return "developer/appList";
    }

    /**
     * 到修改用户的页面
     * @return
     */
    @RequestMapping("/toEditUser")
    public String editUser(HttpServletRequest request){
        request.setAttribute("dUser",(DevUser)request.getSession().getAttribute("devUser"));
        return "/developer/devUserEdit";
    }

    /**
     * 修改用户信息
     * @return
     */
    @RequestMapping(value = "/editUser",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Object editUser(@Param("devUser")DevUser devUser){
        devUser.setModifyBy(devUser.getId());
        devUser.setModifyDate(new Date());
        return devUserService.updateUser(devUser);
    }

    /**
     * 判断是否存在用户编码
     * @return
     */
    @RequestMapping(value = "/existUserCode",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Object existUserCode(@RequestParam("code") String code){
        DevUser devUser=new DevUser();
        devUser.setDevCode(code);
        Message message=new Message();
        if(code==""||code==null){
            message.setCount(-1);
            message.setMessage("empty");
        }else{
           if(devUserService.findDevUser(devUser).size()>0){
               message.setCount(1);
               message.setMessage("exist");
           }else{
               message.setCount(0);
               message.setMessage("noExist");
           }
        }
        return message;
    }


    @RequestMapping("/toAddUser")
    public String toAddUser(){
        return "developer/adddevUser";
    }

    /**
     * 添加用户对象
     * @return
     */
    @RequestMapping(value = "/addDevUser",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Object addUser(DevUser devUser,HttpServletRequest request){
        devUser.setCreatedBy(((DevUser)request.getSession().getAttribute("devUser")).getId());
        devUser.setCreationDate(new Date());
        return devUserService.addDevUser(devUser);
    }

}
