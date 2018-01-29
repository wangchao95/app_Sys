package cn.appsys.service;

import cn.appsys.pojo.AppVersion;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AppVersionService {
    /**
     * 获得app版本信息
     * @param appVersion
     * @return
     */
    List<AppVersion> getAppVersionList(int aId);

    /**
     * 添加版本对象
     * @param appVersion
     * @return
     */
    int addVersion(AppVersion appVersion);

    /**
     * 获得最新版本
     * @param id
     * @return
     */
    AppVersion getNewVersion(int id);

    /**
     * 修改最新版本
     * @param appVersion
     * @return
     */
    int updateappVersion(AppVersion appVersion) throws Exception;
}
