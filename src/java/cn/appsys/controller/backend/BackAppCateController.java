package cn.appsys.controller.backend;

import cn.appsys.service.AppCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/sysA/appCate")
public class BackAppCateController {

    @Resource(name = "appCategoryService")
    private AppCategoryService appCategoryService;

    /**
     * 获得一级菜单
     * @return
     */
    @RequestMapping("/firstCate")
    @ResponseBody
    public Object firstCate(){
        return appCategoryService.findCateByParentId(null);
    }

    @RequestMapping("/categorylevellist2")
    @ResponseBody
    public Object getCateSecond(@RequestParam(value = "pid",required = false) String pid){
        if(pid==""||pid==null||pid.equalsIgnoreCase("")){
            return appCategoryService.findCateByParentId(null);
        }
        return appCategoryService.findCateByParentId(Integer.parseInt(pid));
    }

}
