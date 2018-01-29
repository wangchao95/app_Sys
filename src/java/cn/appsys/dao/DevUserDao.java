package cn.appsys.dao;

import cn.appsys.pojo.DevUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 开发者
 */
public interface DevUserDao {
    /**
     * 获得用户对象
     * @param devUser
     * @return
     */
    DevUser getDevUser(DevUser devUser);

    /**
     * 修改用户信息
     * @param devUser
     * @return
     */
    int updateUser(DevUser devUser);

    /**
     *条件 查询用户信息
     * @param devUser
     * @return
     */
    List<DevUser> findDevUser(@Param("devUser") DevUser devUser);

    /**
     * 添加用户信息
     * @param devUser
     * @return
     */
    int addDevUser(DevUser devUser);

}
