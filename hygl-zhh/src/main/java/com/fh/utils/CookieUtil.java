package com.fh.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
    /**
     * 写cookie
     */
    public static void writeCookie(String name, String value, String domain, int maxage, HttpServletResponse response){
        /*创建cookie*/
        Cookie cookie  =  new Cookie(name,value);
        /*配置参数*/
        /*域名*/
        cookie.setDomain(domain);
        /*过期时间 以秒为单位*/
        if (maxage>0){
            cookie.setMaxAge(maxage);
        }
        /*网站的根路径*/
        cookie.setPath("/");
        /*服务端响应信息*/
        response.addCookie(cookie);
    }

    /**
     * 读取客户端cookie
     */
    public static String readCookie(HttpServletRequest request, String name){
        Cookie[] cookies = request.getCookies();
        if(cookies == null){
            return "";
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(name)){
                return  cookie.getValue();
            }
        }
        return  "";
    }
}
