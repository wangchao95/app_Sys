package cn.appsys.service;

import cn.appsys.pojo.DevUser;

import java.util.List;

public interface DevUserService {

    /**
     * 登录方法
     * @param devUser
     * @return
     */
    DevUser findUser(DevUser devUser);

    /**
     * 修改用户信息
     * @param devUser
     * @return
     */
    int updateUser(DevUser devUser);

    /**
     * 多条件查询用户信息
     * @param devUser
     * @return
     */
    List<DevUser> findDevUser(DevUser devUser);

    /**
     * 添加用户对象
     * @param devUser
     * @return
     */
    int addDevUser(DevUser devUser);
}
