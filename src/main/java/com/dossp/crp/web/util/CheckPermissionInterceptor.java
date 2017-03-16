/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: CheckPermissionInterceptor.java 
 *
 * @Date:  2016年10月26日  下午4:29:15
 *
 * @Package com.dossp.cris.web.util
 */


package com.dossp.crp.web.util;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author yufenghui
 * </p>
 * 日期：2016年10月26日 下午4:29:15
 * </p>
 * 描述：
 *
 */

public class CheckPermissionInterceptor implements HandlerInterceptor {
	
	/** 
	 * @param request
	 * @param response
	 * @param handler
	 * @return
	 * @throws Exception 
	 */

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = requestUri.substring(contextPath.length());
		
		if (validator(request, url)) {
			return true;
		} else {
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<script>");
			out.println("window.open ('" + request.getContextPath() + "/', '_top')");
			out.println("</script>");
			out.println("</html>");
			return false;
		}
	}

	/** 
	 * @param request
	 * @param response
	 * @param handler
	 * @param modelAndView
	 * @throws Exception 
	 */

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// do nothing

	}

	/** 
	 * @param request
	 * @param response
	 * @param handler
	 * @param ex
	 * @throws Exception 
	 */

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// do nothing

	}
	
	private boolean validator(HttpServletRequest request, String url) {
		// 去掉对共用页面的过滤
		UserSessionModel user = SessionUtil.getUser(request);
		
		List<String> publicUrlList = publicUrlList();
		
		if(publicUrlList.contains(url)) {
			return true;
		}
		if (url.startsWith("/static")) {
			return true;
		}
		
		if (user == null) {
			return false;
		} else {
			return true;
		}
		
	}
	
	private List<String> publicUrlList() {
		List<String> list = new ArrayList<String>();
		
		list.add("/");
		list.add("/check_login");
		
		return list;
	}

}
