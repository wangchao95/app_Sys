package cn.appsys.service.impl;

import cn.appsys.dao.AppInfoDao;
import cn.appsys.dao.AppVersionDao;
import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.AppVersion;
import cn.appsys.service.AppInfoService;
import cn.appsys.tools.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service("appInfoService")
public class AppInfoServiceImpl implements AppInfoService {

    @Resource(name = "appInfoDao")
    private AppInfoDao appInfoDao;

    @Resource(name = "appVersionDao")
    private AppVersionDao appVersionDao;

    /**
     * 分页获得祥光信息
     * @param
     * @param page
     */
    public void getPageList(AppInfo appInfo,Page page) {
        List<AppInfo> appInfoList=new ArrayList<AppInfo>();
        page.setTotalCount(appInfoDao.findAppInfoCountByParam(appInfo));
        appInfoList=appInfoDao.findAppInfoByParam(appInfo,(page.getCurrPageNo()-1)*page.getPageSize(),page.getPageSize());
        page.setNewPage(appInfoList);
    }

    /**
     * 根据APk码获得是否存在相同的APK码
     * @param apkName
     * @return
     */
    public int  getAppByApkName(String apkName) {
        AppInfo appInfo=new AppInfo();
        appInfo.setAPKName(apkName);
        return appInfoDao.getAppByApkName(appInfo);
    }

//    /**
//     * 根据信息获得软件名称
//     * @param appInfo
//     * @return
//     */
//    public int getAppByParam(AppInfo appInfo) {
//        return appInfoDao.getAppByApkName(appInfo);
//    }

    /**
     * 添加app软件信息
     * @param appInfo
     * @return
     */
    public int addAppInfo(AppInfo appInfo) {
        return appInfoDao.addAppInfo(appInfo);
    }


    public List<AppInfo> getAppByParm(AppInfo appInfo) {
        return appInfoDao.getAppInfoByParam(appInfo);
    }

    /**
     * 修改软件的方法
     * @param appInfo
     * @return
     */
    public int updateApp(AppInfo appInfo) {
        return appInfoDao.updateAppInfo(appInfo);
    }

    /**
     * 删除指定的app信息和版本信息
     * @param appInfo
     * @return
     */
    public int deleteAppInfo(AppInfo appInfo) {
        AppVersion appVersion=new AppVersion();
        appVersion.setAppId(appInfo.getId());
        //先删除子表，如果子表删除成功，就可以删除主表
        if(appVersionDao.delAppVersion(appVersion)>=0){
            return appInfoDao.delAppInfo(appInfo);
        }else{
            return -1;
        }
    }

    /**
     * 上下架操作
     * @param appInfo
     * @return
     */
    public int openOrCloseApp(AppInfo appInfo) {
        return appInfoDao.updateAppInfo(appInfo);
    }
}
