package cn.appsys.controller.backend;

import cn.appsys.service.DictionaryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/sysA/dcitory")
public class BackDicController {

    @Resource(name = "dicService")
    private DictionaryService dicService;

    /**
     * 查找平台等方法
     * @param tcode
     * @return
     */
    @RequestMapping("/datadictionarylist")
    @ResponseBody
    public Object getDivInfo(@RequestParam("tcode") String tcode){
        return dicService.findDicInfoByParam(tcode);
    }

}
