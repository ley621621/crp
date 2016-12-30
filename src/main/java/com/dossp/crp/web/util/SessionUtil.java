/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: SessionUtil.java 
 *
 * @Date:  2016年10月17日  上午11:00:19
 *
 * @Package com.dossp.mcprc.cmr.web.das.util
 */


package com.dossp.crp.web.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author yufenghui
 * </p>
 * 日期：2016年10月17日 上午11:00:19
 * </p>
 * 描述：
 *
 */

public final class SessionUtil {
	
	/**
	 * 
	 * @param request
	 * @param model
	 */
	public static void saveUser(HttpServletRequest request, UserSessionModel model) {
		
		HttpSession session = request.getSession();
		session.setAttribute("user", model);
	}
	
	/**
	 * 
	 * @param request
	 * @param model
	 */
	public static UserSessionModel getUser(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		return (UserSessionModel) session.getAttribute("user");
	}
	
	/**
	 * 
	 * @param request
	 * @param model
	 */
	public static void removeUser(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.removeAttribute("user");
	}

}
