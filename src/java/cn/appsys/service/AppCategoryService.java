package cn.appsys.service;

import cn.appsys.pojo.AppCategory;

import java.util.List;

public interface AppCategoryService {
    /**
     * 查找菜单
     * @param parentId
     * @return
     */
    List<AppCategory> findCateByParentId(Integer parentId);
}
