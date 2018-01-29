package cn.appsys.dao;

import cn.appsys.pojo.AppInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppInfoDao {

    /**
     * 根据条件获得集合
     * @param appInfo
     * @param limitFirst
     * @param pageSize
     * @return
     */
    List<AppInfo> findAppInfoByParam(@Param("appInfo") AppInfo appInfo,@Param("limitFirst") Integer limitFirst,@Param("pageSize") Integer pageSize);


    /**
     * 查询指定的信息的app个数
     * @param
     * @return
     */
    int findAppInfoCountByParam(@Param("appInfo") AppInfo appInfo);

    /**
     * 添加软件信息
     * @param appInfo
     * @return
     */
    int addAppInfo(AppInfo appInfo);

    /**
     * 更具APK获得软件对象
     * @param apkName
     * @return
     */
    int getAppByApkName(AppInfo appInfo);

    /**
     * 修改App最新版本信息
     * @param appInfo
     * @return
     */
    int updateAppInfo(AppInfo appInfo);

    /**
     * 获得软件的信息
     * @param appInfo
     * @return
     */
    List<AppInfo> getAppInfoByParam(AppInfo appInfo);

    /**
     * 删除指定条件的app软件
     * @param appInfo
     * @return
     */
    int delAppInfo(AppInfo appInfo);

}
