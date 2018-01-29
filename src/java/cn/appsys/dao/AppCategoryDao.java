package cn.appsys.dao;

import cn.appsys.pojo.AppCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppCategoryDao {
    /**
     * 根据父菜单查找子菜单
     * @param parentId
     * @return
     */
    List<AppCategory> getCateByparentId(@Param("parentId") Integer parentId);

}
