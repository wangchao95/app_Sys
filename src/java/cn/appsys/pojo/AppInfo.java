package cn.appsys.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * app的信息
 */
public class AppInfo {
    private int id;
    private String softwareName;  //软件名称
    private String APKName;  //APK名称
    private String supportROM;  //支持的ROM
    private String interfaceLanguage;  //界面语言
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateDate;   //修改日期
    private BigDecimal softwareSize;//软件大小
    private int devId;   //开发者
    private String appInfo;//软件的信息
    private int status;   //app的状态
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date onSaleDate;   //上架时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date offSaleDate; //下架时间
    private int flatformId;//app所属平台id;
    private int categoryLevel3;//所属的3级分类
    private int  downloads;//下载量
    private int createdBy;//创建者
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date creationDate;//创建时间
    private int modifyBy;  //修改者
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date modifyDate;  //修改时间
    private int categoryLevel1; //所属的1级菜单
    private int categoryLevel2;  //所属的2级菜单
    private String logoPicPath;//LOGO图片路径
    private  String logoLocPath;  //logo图片服务器存储路径
    private int versionId;  //最新版本的Id

    private List<AppVersion> appVersion=new ArrayList<AppVersion>();  //一个app基础信息对应多个版本对象

    private String statusName;//app状态名称
    private String flatformName;//app所属平台名称
    private String categoryLevel3Name;//所属三级分类名称
    private String devName;//开发者名称
    private String versionNo;//最新的版本号
    private String categoryLevel1Name;//所属一级分类名称
    private String categoryLevel2Name;//所属二级分类名称


    public List<AppVersion> getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(List<AppVersion> appVersion) {
        this.appVersion = appVersion;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getFlatformName() {
        return flatformName;
    }

    public void setFlatformName(String flatformName) {
        this.flatformName = flatformName;
    }

    public String getCategoryLevel3Name() {
        return categoryLevel3Name;
    }

    public void setCategoryLevel3Name(String categoryLevel3Name) {
        this.categoryLevel3Name = categoryLevel3Name;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public String getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }

    public String getCategoryLevel1Name() {
        return categoryLevel1Name;
    }

    public void setCategoryLevel1Name(String categoryLevel1Name) {
        this.categoryLevel1Name = categoryLevel1Name;
    }

    public String getCategoryLevel2Name() {
        return categoryLevel2Name;
    }

    public void setCategoryLevel2Name(String categoryLevel2Name) {
        this.categoryLevel2Name = categoryLevel2Name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSoftwareName() {
        return softwareName;
    }

    public void setSoftwareName(String softwareName) {
        this.softwareName = softwareName;
    }

    public String getAPKName() {
        return APKName;
    }

    public void setAPKName(String APKName) {
        this.APKName = APKName;
    }

    public int getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(int modifyBy) {
        this.modifyBy = modifyBy;
    }

    public String getSupportROM() {
        return supportROM;
    }

    public void setSupportROM(String supportROM) {
        this.supportROM = supportROM;
    }

    public String getInterfaceLanguage() {
        return interfaceLanguage;
    }

    public void setInterfaceLanguage(String interfaceLanguage) {
        this.interfaceLanguage = interfaceLanguage;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public BigDecimal getSoftwareSize() {
        return softwareSize;
    }

    public void setSoftwareSize(BigDecimal softwareSize) {
        this.softwareSize = softwareSize;
    }

    public int getDevId() {
        return devId;
    }

    public void setDevId(int devId) {
        this.devId = devId;
    }

    public String getAppInfo() {
        return appInfo;
    }

    public void setAppInfo(String appInfo) {
        this.appInfo = appInfo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getOnSaleDate() {
        return onSaleDate;
    }

    public void setOnSaleDate(Date onSaleDate) {
        this.onSaleDate = onSaleDate;
    }

    public Date getOffSaleDate() {
        return offSaleDate;
    }

    public void setOffSaleDate(Date offSaleDate) {
        this.offSaleDate = offSaleDate;
    }

    public int getFlatformId() {
        return flatformId;
    }

    public void setFlatformId(int flatformId) {
        this.flatformId = flatformId;
    }

    public int getCategoryLevel3() {
        return categoryLevel3;
    }

    public void setCategoryLevel3(int categoryLevel3) {
        this.categoryLevel3 = categoryLevel3;
    }

    public int getDownloads() {
        return downloads;
    }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getModifyId() {
        return modifyBy;
    }

    public void setModifyId(int modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public int getCategoryLevel1() {
        return categoryLevel1;
    }

    public void setCategoryLevel1(int categoryLevel1) {
        this.categoryLevel1 = categoryLevel1;
    }

    public int getCategoryLevel2() {
        return categoryLevel2;
    }

    public void setCategoryLevel2(int categoryLevel2) {
        this.categoryLevel2 = categoryLevel2;
    }

    public String getLogoPicPath() {
        return logoPicPath;
    }

    public void setLogoPicPath(String logoPicPath) {
        this.logoPicPath = logoPicPath;
    }

    public String getLogoLocPath() {
        return logoLocPath;
    }

    public void setLogoLocPath(String logoLocPath) {
        this.logoLocPath = logoLocPath;
    }

    public int getVersionId() {
        return versionId;
    }

    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }
}
