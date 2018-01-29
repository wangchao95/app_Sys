package cn.appsys.tools;

import cn.appsys.pojo.AppVersion;

public class Message {
//    1:表示成功，0：表示失败
    private int  count;
    //提示消息
    private String message;

    private AppVersion appVersion;

    public AppVersion getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(AppVersion appVersion) {
        this.appVersion = appVersion;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
