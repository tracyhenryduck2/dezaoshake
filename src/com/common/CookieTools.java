package com.common;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieTools {

	
	
	/**
	 * 设置cookie
	 * @param response
	 * @param name  cookie名字
	 * @param value cookie值
	 * @param maxAge cookie生命周期  以秒为单位
	 */
	public static void addCookie(HttpServletResponse response,String name,String value,int maxAge){
	    Cookie cookie = new Cookie(name,value);
	    cookie.setPath("/");
	    if(maxAge>0)  cookie.setMaxAge(maxAge);
	    response.addCookie(cookie);
	}
	
	/**
	 * 根据名字获取cookie
	 * @param request
	 * @param name cookie名字
	 * @return
	 */
	public static Cookie getCookieByName(HttpServletRequest request,String name){
	    Map<String,Cookie> cookieMap = ReadCookieMap(request);
	    if(cookieMap.containsKey(name)){
	        Cookie cookie = (Cookie)cookieMap.get(name);
	        return cookie;
	    }else{
	        return null;
	    }   
	}
	
	 
	/**
	 * 将cookie封装到Map里面
	 * @param request
	 * @return
	 */
	private static Map<String,Cookie> ReadCookieMap(HttpServletRequest request){  
	    Map<String,Cookie> cookieMap = new HashMap<String,Cookie>();
	    Cookie[] cookies = request.getCookies();
	    if(null!=cookies){
	        for(Cookie cookie : cookies){
	            cookieMap.put(cookie.getName(), cookie);
	        }
	    }
	    return cookieMap;
	}
	
	/**
	 * 获取ip地址
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) { 
	       String ip = request.getHeader("x-forwarded-for"); 
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	           ip = request.getHeader("Proxy-Client-IP"); 
	       } 
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	           ip = request.getHeader("WL-Proxy-Client-IP"); 
	       } 
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	           ip = request.getRemoteAddr(); 
	       } 
	       return ip; 
	 } 
	
}
