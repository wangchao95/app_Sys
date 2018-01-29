package cn.appsys.dao;

import cn.appsys.pojo.DataDictionary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 字典接口Dao
 */
public interface DicDao {
    /**
     * 根据类型编码查询信息
     * @param typeCode
     * @return
     */
    List<DataDictionary> getDicInfoByParam(@Param("typeCode") String typeCode);
}
