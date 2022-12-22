package com.example.j2eefinalv2.interceptor;

import com.example.j2eefinalv2.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截器
 */
@Component
public class LoginInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        // 获取请求的URL
        String url = request.getRequestURI();
        // URL:除了login是可以公开访问的，其它的URL都进行拦截控制
        if(url.indexOf("/login")>=0 ||url.indexOf("/register")>=0){
            return true;
        }
        // 获取Session
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        // 判断Session中是否有用户数据，如果有，则返回true,继续向下执行
        if(user != null){
            return true;
        }
        // 不符合条件的给出提示信息，并转发到登录页面
        request.setAttribute("msg", "您还没有登录，请先登录！");
        request.getRequestDispatcher("/login").forward(request, response);
        return false;
    }
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }
}