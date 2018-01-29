package cn.appsys.service.impl;

import cn.appsys.dao.AppInfoDao;
import cn.appsys.dao.AppVersionDao;
import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.AppVersion;
import cn.appsys.service.AppVersionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("appVersionService")
public class AppVersionServiceImpl implements AppVersionService {

    @Resource(name = "appVersionDao")
    private AppVersionDao appVersionDao;
    @Resource(name = "appInfoDao")
    private AppInfoDao appInfoDao;

    /**
     * c查找版本信息
     * @param appVersion
     * @return
     */
    public List<AppVersion> getAppVersionList(int aId) {
        return appVersionDao.getVersionList(aId);
    }

    /**
     * 添加版本方法
     * @param appVersion
     * @return
     */
    public int addVersion(AppVersion appVersion) {
       if(appVersionDao.addAppVersion(appVersion)>0){
           AppInfo appInfo=new AppInfo();
           appInfo.setId(appVersion.getAppId());
           appInfo.setVersionId(appVersion.getId());
          return  appInfoDao.updateAppInfo(appInfo);
       }else{
           return -1;
       }
    }

    /**
     * 获得最新版本
     * @param id
     * @return
     */
    public AppVersion getNewVersion(int id) {
        return appVersionDao.getNewVersion(id);
    }

    /**
     * 修改最新版本
     * @param appVersion
     * @return
     */
    public int updateappVersion(AppVersion appVersion) throws Exception {
        return appVersionDao.updateVersion(appVersion);
    }
}
