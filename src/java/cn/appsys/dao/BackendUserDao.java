package cn.appsys.dao;

import cn.appsys.pojo.BackendUser;

/**
 * 后台用户类
 */
public interface BackendUserDao {
    /**
     * 获得后台用户对象
     * @param backendUser
     * @return
     */
    public BackendUser getBackUser(BackendUser backendUser);
}
