package com.gloryh.filter;

import com.gloryh.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 用户登录过滤器未登录则跳转回login
 *
 * @author 黄光辉
 * @since 2020/11/2
 **/
@WebFilter(urlPatterns = {"/index.html"},filterName = "userFilter")
public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //判断session中是否有对应的用户信息，没有则返回登录页面
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        User user =(User)session.getAttribute("user");
        if(user ==null){
            //用户信息为null，重定向到登录页面
            response.sendRedirect("login.html");
        }else{
            //user不为null，放行
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
