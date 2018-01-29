package cn.appsys.dao;

import cn.appsys.pojo.AppVersion;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface AppVersionDao {
    /**
     * 通过appVersion的版本信息获得版本集合
     * @param appVersion
     * @return
     */
    List<AppVersion> getVersionList(@Param("appId") int appId);

    int addAppVersion(AppVersion appVersion);

    /**
     * 查找最新的appVersion
     * @param id
     * @return
     */
    AppVersion getNewVersion(@RequestParam("id") int id);

    /**
     * 修改最新版本
     * @param appVersion
     * @return
     */
    int updateVersion(AppVersion appVersion);

    /**
     * 删除指定条件的app版本对象
     * @param appVersion
     * @return
     */
    int delAppVersion(AppVersion appVersion);
}
