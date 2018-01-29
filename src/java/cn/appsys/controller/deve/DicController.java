package cn.appsys.controller.deve;

import cn.appsys.service.DictionaryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 字典控制类
 */
@Controller
@RequestMapping("/sys/dictionary")
public class DicController {
    @Resource(name = "dicService")
    private DictionaryService dictionaryService;

    @RequestMapping("/datadictionarylist")
    @ResponseBody
    public Object getDivInfo(@RequestParam("tcode") String tcode){
        return dictionaryService.findDicInfoByParam(tcode);
    }
}
