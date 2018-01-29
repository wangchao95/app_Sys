package cn.appsys.controller.backend;

import cn.appsys.pojo.AppInfo;
import cn.appsys.service.AppInfoService;
import cn.appsys.tools.Page;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/sysA/appCheck")
public class AppCheckController {

    @Resource(name = "appInfoService")
    private AppInfoService appInfoService;

    /**
     * 到app列表的页面方法
     * @return
     */
    @RequestMapping("/appList")
    public Object getappList(){
        return "backend/applist";
    }

    /**
     * 分页显示信息     *
     * @param appInfo
     * @param pageIndex
     * @return
     */
    @RequestMapping(value = "/appListPage",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Object getPageList(AppInfo appInfo,@RequestParam(value="pageIndex",required=false) String pageIndex){
        Integer pIndex=(pageIndex.equalsIgnoreCase("null"))?null:Integer.parseInt(pageIndex);
        Integer status=1;
        Page page=new Page();
        page.setCurrPageNo(pIndex);
        page.setPageSize(3);
        appInfoService.getPageList(appInfo,page);
        return  JSON.toJSONStringWithDateFormat(page,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteMapNullValue);
    }

    /**
     * 审核APP最新版本
     * @return
     */
    @RequestMapping("/toAppCheck/{id}")
    public String toCheckApp(@PathVariable(value = "id",required = false) String id,Model model){
        AppInfo appInfo=new AppInfo();
        appInfo.setId(Integer.parseInt(id));
        model.addAttribute("appInfo", appInfoService.getAppByParm(appInfo).get(0));
        return "backend/appcheck";
    }

    /**
     * 审核操作
     * @return
     */
   @RequestMapping(value = "/checkSave",produces = {"application/json;charset=utf-8"})
   @ResponseBody
    public Object checkApp(@RequestParam(value = "aid",required = false) String aid,
                           @RequestParam(value = "status",required = false) String status){
       AppInfo appInfo=new AppInfo();
       appInfo.setStatus(Integer.parseInt(status));
       appInfo.setId(Integer.parseInt(aid));
        return appInfoService.updateApp(appInfo);
    }

}
