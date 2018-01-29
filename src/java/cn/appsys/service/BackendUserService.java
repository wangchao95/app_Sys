package cn.appsys.service;

import cn.appsys.pojo.BackendUser;

public interface BackendUserService {
    /**
     * 登录
     * @return
     */
    public BackendUser BackLogin(BackendUser backendUser);
}
