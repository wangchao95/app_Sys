package cn.appsys.controller.deve;

import cn.appsys.service.AppCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/sys/appCate")
public class AppCateController {

    @Resource(name = "appCategoryService")
    private AppCategoryService appCategoryService;

    /**
     * 获得一级菜单方法
     * @return
     */
    @RequestMapping("/firstCate")
    @ResponseBody
    public Object firstCate(){
        return appCategoryService.findCateByParentId(null);
    }

}
