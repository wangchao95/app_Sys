package cn.appsys.interceptor;

import cn.appsys.pojo.BackendUser;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SysInterceptorA extends HandlerInterceptorAdapter {


    /**
     * 拦截的方法
     * @return
     */
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp,Object handler) throws Exception{
        BackendUser backendUser=(BackendUser) req.getSession().getAttribute("backUser");  //获得会话保存的对象
        if(backendUser!=null){
            return true;
        }else{
            resp.sendRedirect(req.getContextPath()+"/401.jsp");
            return false;
        }
    }
}
