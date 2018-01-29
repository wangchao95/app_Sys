package cn.appsys.controller.deve;

import cn.appsys.pojo.AppVersion;
import cn.appsys.pojo.DevUser;
import cn.appsys.service.AppVersionService;
import cn.appsys.tools.Message;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@Controller
@RequestMapping("/sys/appVersion")
public class AppVersionController {

   @Resource(name = "appVersionService")
    private AppVersionService appVersionService;


    @RequestMapping(value = "/addVersion",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Object addVersion(AppVersion appVersion, @RequestParam(value = "a_downloadLink",required = false) MultipartFile multipartFile,HttpServletRequest req){
        Message message=new Message();
        String fileName=null;  //默认的路径
        boolean right=true;
        String path=null;
        if(multipartFile!=null&&multipartFile.getSize()>0){
            //保存到服务器的路径
            path=req.getSession().getServletContext().getRealPath("statics" + File.separator + "uploadFiles");
            //获得源文件的名字的后缀
            String backFix= FilenameUtils.getExtension(multipartFile.getOriginalFilename());
            int size=500000000;
            if(multipartFile.getSize()>size){
                message.setCount(-1);
                message.setMessage("上传文件尺寸太大！不得超过50000000KB");
                right=false;
            }else if(backFix.equalsIgnoreCase("apk")||backFix.equalsIgnoreCase("jpg")){
                fileName = System.currentTimeMillis() + Math.round(1000) + "version.apk";
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
                message.setMessage("上传文件格式不对,必须为apk后缀");
                right=false;
            }
        }
        if(right){
            appVersion.setDownloadLink(path==null?null:path+File.separator+fileName);
            appVersion.setCreatedBy(((DevUser)req.getSession().getAttribute("devUser")).getId());
            appVersion.setCreationDate(new Date());
            appVersion.setApkLocPath(path==null?null:path+File.separator+fileName);
            appVersion.setApkFileName(fileName);
            message.setCount(appVersionService.addVersion(appVersion));
            message.setAppVersion(appVersion);
        }
        return message;
    }

    /**
     * 修改appVersion的最新版本
     * @param appVersion
     * @return
     */
    @RequestMapping(value = "/editVersion",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Object editVersion(AppVersion appVersion,HttpServletRequest request){
        appVersion.setModifyBy(((DevUser)request.getSession().getAttribute("devUser")).getId());
        appVersion.setModifyDate(new Date());
        try {
            return appVersionService.updateappVersion(appVersion)>0?appVersion:0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1  ;
        }
    }
}
