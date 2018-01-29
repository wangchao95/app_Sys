package cn.appsys.service;

import cn.appsys.pojo.DataDictionary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DictionaryService {
    /**
     * 查询
     * @param typeCode
     * @return
     */
    List<DataDictionary> findDicInfoByParam(String typeCode);
}
