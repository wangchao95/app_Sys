package cn.appsys.service.impl;

import cn.appsys.dao.BackendUserDao;
import cn.appsys.pojo.BackendUser;
import cn.appsys.service.BackendUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("backendUserService")
public class BackendUserServiceImpl implements BackendUserService {

    @Resource(name = "backendUserDao")
    private BackendUserDao backendUserDao;

    /**
     * 登录的方法
     * @param backendUser
     * @return
     */
    public BackendUser BackLogin(BackendUser backendUser) {
        return backendUserDao.getBackUser(backendUser);
    }
}
