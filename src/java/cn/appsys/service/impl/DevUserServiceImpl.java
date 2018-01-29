package cn.appsys.service.impl;

import cn.appsys.dao.DevUserDao;
import cn.appsys.pojo.DevUser;
import cn.appsys.service.DevUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("devUserService")
public class DevUserServiceImpl implements DevUserService {

    @Resource(name = "devUserDao")
    private DevUserDao devUserDao;

    /**
     * 登录方法
     * @param devUser
     * @return
     */
    public DevUser findUser(DevUser devUser) {
        return  devUserDao.getDevUser(devUser);
    }

    /**
     * 修改用户信息
     * @param devUser
     * @return
     */
    public int updateUser(DevUser devUser) {
        return devUserDao.updateUser(devUser);
    }

    /**
     * 查询用户信息
     * @param devUser
     * @return
     */
    public List<DevUser> findDevUser(DevUser devUser) {
        return devUserDao.findDevUser(devUser);
    }

    /**
     * 添加用户对象
     * @param devUser
     * @return
     */
    public int addDevUser(DevUser devUser) {
        return devUserDao.addDevUser(devUser);
    }
}
