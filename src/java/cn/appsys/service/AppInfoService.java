package cn.appsys.service;

import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.AppVersion;
import cn.appsys.tools.Page;
import org.apache.log4j.Logger;

import java.util.List;

public interface AppInfoService {
    Logger log=Logger.getLogger(AppInfoService.class);
    /**
     * 分页获得相关页面的集合
     * @param appInfo
     * @param page
     */
    void getPageList(AppInfo appInfo,Page page);

    int getAppByApkName(String apkName);

//    /**
//     * 根据添加获得app软件
//     * @param appInfo
//     * @return
//     */
//    int getAppByParam(AppInfo appInfo);

    int addAppInfo(AppInfo appInfo);

    /**
     * 获得软件信息
     * @param appInfo
     * @return
     */
    List<AppInfo> getAppByParm(AppInfo appInfo);

    /**
     * 修改软件的方法
     * @param appInfo
     * @return
     */
    int updateApp(AppInfo appInfo);

    /**
     * 删除app信息
     * @param appInfo
     * @return
     */
    int deleteAppInfo(AppInfo appInfo);

    /**
     * 上下架操作
     * @param appInfo
     * @return
     */
    int openOrCloseApp(AppInfo appInfo);

}
