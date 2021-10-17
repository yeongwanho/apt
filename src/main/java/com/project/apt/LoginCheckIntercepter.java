package com.project.apt;

import com.project.apt.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckIntercepter implements HandlerInterceptor {

    @Autowired
    private JwtService service;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println(request.getMethod() + " : " + request.getServletPath());
        if(request.getMethod().equals("OPTIONS")){
            return true;
        }else {
            String token= request.getHeader("jwt-auth-token");
            if (token != null && token.length()>0){
                service.checkValid(token);
                return true;

            }else {
                throw new RuntimeException("인증 토큰이 없습니다");
            }

        }
    }
}
