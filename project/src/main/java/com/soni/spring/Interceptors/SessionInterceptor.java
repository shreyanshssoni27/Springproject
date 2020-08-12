package com.soni.spring.Interceptors;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class SessionInterceptor extends HandlerInterceptorAdapter
{


	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		
		
		HttpSession httpsession = request.getSession();
		String load =  (String) httpsession.getAttribute("login");
		
			if((Objects.isNull(load)) ||  (load.equals(""))) {
				return true;
			} else if(load.equals("adminuser")) {
				response.sendRedirect("admin");
			}else if(load.equals("user")) {
				response.sendRedirect("user");
			}
				return true;
			}
				
		

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}
}