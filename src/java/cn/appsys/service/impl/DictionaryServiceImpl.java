package cn.appsys.service.impl;

import cn.appsys.dao.DicDao;
import cn.appsys.pojo.DataDictionary;
import cn.appsys.service.DictionaryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("dicService")
public class DictionaryServiceImpl implements DictionaryService {
    @Resource(name = "dicDao")
    private DicDao dicDao;

    public List<DataDictionary> findDicInfoByParam(String typeCode) {
        return dicDao.getDicInfoByParam(typeCode);
    }
}
