package cn.appsys.service.impl;

import cn.appsys.dao.AppCategoryDao;
import cn.appsys.pojo.AppCategory;
import cn.appsys.service.AppCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("appCategoryService")
public class AppCateServiceImpl implements AppCategoryService {

    @Resource(name = "appCategoryDao")
    private AppCategoryDao appCategoryDao;

    public List<AppCategory> findCateByParentId(Integer parentId) {
        return appCategoryDao.getCateByparentId(parentId);
    }
}
