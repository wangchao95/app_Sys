package cn.appsys.controller.deve;

import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.AppVersion;
import cn.appsys.pojo.DevUser;
import cn.appsys.service.AppCategoryService;
import cn.appsys.service.AppInfoService;
import cn.appsys.service.AppVersionService;
import cn.appsys.tools.Message;
import cn.appsys.tools.Page;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.odps.udf.CodecCheck;
import org.apache.commons.io.FilenameUtils;
import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import sun.awt.SunHints;
import sun.misc.Version;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.swing.plaf.SplitPaneUI;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/sys/appInfo")
public class AppInfoController {
    @Resource(name = "appInfoService")
    private AppInfoService appInfoService;

    @Resource(name = "appCategoryService")
    private AppCategoryService appCategoryService;

    @Resource(name = "appVersionService")
    private AppVersionService appVersionService;

    @RequestMapping("/appJsp")
    public  String toAppInfo(){
        return "developer/appList";
    }

    @RequestMapping("/main")
    public  String toMain(){
        return "developer/main";
    }


    @RequestMapping(value = "/appListPage",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Object getPageList(AppInfo appInfo,@RequestParam(value="pageIndex",required=false) String pageIndex){
        Integer pIndex=(pageIndex.equalsIgnoreCase("null"))?null:Integer.parseInt(pageIndex);
        Page page=new Page();
        page.setCurrPageNo(pIndex);
        page.setPageSize(3);
         appInfoService.getPageList(appInfo,page);
        return  JSON.toJSONStringWithDateFormat(page,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteMapNullValue);
    }


    @RequestMapping("/categorylevellist2")
    @ResponseBody
    public Object getCateSecond(@RequestParam(value = "pid",required = false) String pid){
        if(pid==""||pid==null||pid.equalsIgnoreCase("")){
            return appCategoryService.findCateByParentId(null);
        }
        return appCategoryService.findCateByParentId(Integer.parseInt(pid));
    }

    @RequestMapping("/toAddApp")
    public String toAddApp(){
        return "developer/addApp";
    }


//    /**
//     * 判断是否存在此apk码
//     * @return
//     */
    @RequestMapping("/apkexist")
    @ResponseBody
    public Object eapkExist(@RequestParam("APKName") String apkName){
        AppInfo appInfo=new AppInfo();
        appInfo.setAPKName("noExist");
        if(apkName==null||apkName.equalsIgnoreCase("")){
            appInfo.setAPKName("empty");
        }else if(appInfoService.getAppByApkName(apkName)>0){
            appInfo.setAPKName("exist");
        }
        return appInfo;
    }

    /**
     * 添加软件方法
     * @return
     */
    @RequestMapping(value = "/addAppInfo",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Object addAppInfo(AppInfo appInfo,HttpServletRequest req,@RequestParam(value = "logoPic",required = false) MultipartFile multipartFile){
        Message message=new Message();
        String fileName=null;  //默认的路劲
        boolean right=true;
        String path=null;
        if(multipartFile!=null&&multipartFile.getSize()>0){
            //保存到服务器的路径
             path=req.getSession().getServletContext().getRealPath("statics" + File.separator + "uploadFiles");
            //获得源文件的名字的后缀
            String backFix= FilenameUtils.getExtension(multipartFile.getOriginalFilename());
            int size=50000000;
            if(multipartFile.getSize()>size){
                message.setCount(-1);
                message.setMessage("上传文件尺寸太大！不得超过500000KB");
                right=false;
            }else if(backFix.equalsIgnoreCase("jpeg")||backFix.equalsIgnoreCase("jpg")||backFix.equalsIgnoreCase("png")){
                fileName = System.currentTimeMillis() + Math.round(1000) + "person.jpg";
                //创建目标文件夹
                File targFile=new File(path,fileName);
                if(!targFile.exists()){
                    targFile.mkdir();
                }
                //保存
                try {
                    multipartFile.transferTo(targFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ;
            }else{
                message.setCount(-1);
                message.setMessage("上传文件格式不对");
                right=false;
            }
        }
        if(right){
            appInfo.setCreatedBy(((DevUser)req.getSession().getAttribute("devUser")).getId());
            appInfo.setLogoPicPath(fileName);
            appInfo.setLogoLocPath(path==null?null:path+File.separator+fileName);
            appInfo.setCreationDate(new Date());
            appInfo.setDevId(((DevUser)req.getSession().getAttribute("devUser")).getId());
            message.setCount(appInfoService.addAppInfo(appInfo));
        }
        return message;
    }

    @RequestMapping("/toEditApp/{id}")
    public String toEditApp(@PathVariable("id") String id,HttpServletRequest request){
        AppInfo appInfo=new AppInfo();
        appInfo.setId(Integer.parseInt(id));
        request.setAttribute("appInfo", appInfoService.getAppByParm(appInfo).get(0));
        return "/developer/appinfomodify";
    }

    @RequestMapping(value = "/editApp",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Object editApp(@Param("appInfo") AppInfo appInfo, HttpServletRequest request, @RequestParam(value = "photo",required = false) MultipartFile multipartFile,
                          @RequestParam("oldPhoto") String oldPhoto, @RequestParam(value = "status",required = false) String status){
        Message message=new Message();
        String path=null;
        int appStatus=0;
        String fileName=null;
        boolean right=true;
        if(multipartFile!=null&&multipartFile.getSize()>0){
            //保存到服务器的路径
            path=request.getSession().getServletContext().getRealPath("statics" + File.separator + "uploadFiles");
            //获得源文件的名字的后缀
            String backFix= FilenameUtils.getExtension(multipartFile.getOriginalFilename());
            int size=50000000;
            if(multipartFile.getSize()>size){
                message.setCount(-1);
                message.setMessage("上传文件尺寸太大！不得超过500000KB");
                right=false;
            }else if(backFix.equalsIgnoreCase("jpeg")||backFix.equalsIgnoreCase("jpg")||backFix.equalsIgnoreCase("png")){
                fileName = System.currentTimeMillis() + Math.round(1000) + "person.jpg";
                //创建目标文件夹
                File targFile=new File(path,fileName);
                if(!targFile.exists()){
                    targFile.mkdir();
                }
                //保存
                try {
                    new File(path,oldPhoto).delete();  //删除原图片
                    multipartFile.transferTo(targFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ;
            }else{
                message.setCount(-1);
                message.setMessage("上传文件格式不对");
                right=false;
            }
        }
        if(right){
            if(status!=null&&status!=""){
                appStatus= Integer.parseInt(status);
            }
            appInfo.setStatus(appStatus);
            appInfo.setModifyBy(((DevUser)request.getSession().getAttribute("devUser")).getId());
            appInfo.setLogoPicPath(fileName);
            appInfo.setLogoLocPath(path==null?null:path+File.separator+fileName);
            appInfo.setModifyDate(new Date());
            appInfo.setDevId(((DevUser)request.getSession().getAttribute("devUser")).getId());
            message.setCount(appInfoService.updateApp(appInfo));
        }
        return message;
    }

    /**
     * 到添加版本页面
     * @return
     */
    @RequestMapping("/toAddVersion/{id}")
    public String toAddVersion(@PathVariable String id,HttpServletRequest request){
        request.setAttribute("appVersionList",appVersionService.getAppVersionList(Integer.parseInt(id)));
        request.setAttribute("aid",id);
        return "developer/appversionadd";
    }
    /**
     * 到修改App版本页面
     */
    @RequestMapping("/toEditVersion/{id}")
    public String toEditVersion(@PathVariable("id") String id,HttpServletRequest request){
        request.setAttribute("appVersionList",appVersionService.getAppVersionList(Integer.parseInt(id)));
        request.setAttribute("appVersion",appVersionService.getNewVersion(Integer.parseInt(id)));
        request.setAttribute("aid",id);
        return "developer/appversionmodify";
    }

    /**
     * 查看app基础信息和版本的页面
     * @return
     */
    @RequestMapping("/toAppView/{id}")
    public  String toAppView(@PathVariable("id") String id,HttpServletRequest request){
        AppInfo appInfo=new AppInfo();
        appInfo.setId(Integer.parseInt(id));
        request.setAttribute("appInfo", appInfoService.getAppByParm(appInfo).get(0));
        return "developer/appinfoview";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/delAppInfo",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Object delAppInfo(@RequestParam("id") String id){
        AppInfo appInfo=new AppInfo();
        appInfo.setId(Integer.parseInt(id));
       return appInfoService.deleteAppInfo(appInfo);       
    }

    /**
     * 上下架操作
     * @return
     */
    @RequestMapping("/openOrCloseApp")
    @ResponseBody
    public  Object optionApp(@RequestParam("aid") String aid,@RequestParam("option") String option){
        AppInfo appInfo=new AppInfo();
        appInfo.setId(Integer.parseInt(aid));
        appInfo.setStatus(option.equalsIgnoreCase("close")?5:4);  //上下架改变的status的值
        return appInfoService.openOrCloseApp(appInfo);
    }
}
