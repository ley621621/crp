/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: SystemController.java 
 *
 * @Date:  2016年10月24日  下午12:57:09
 *
 * @Package com.dossp.cris.web.system
 */


package com.dossp.crp.web.system;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author yufenghui
 * </p>
 * 日期：2016年10月24日 下午12:57:09
 * </p>
 * 描述：
 *
 */
@Controller
@RequestMapping(value = "/")
public class SystemController {
	
	/**
	 * 跳转到登录界面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/")
	public String to_login() {
		
		return "/login";
	}
	
	/**
	 * 错误页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "error")
	public void error(HttpServletRequest request, HttpServletResponse response) {
		try {
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<script>");
			out.println("window.open ('" + request.getContextPath() + "/', '_top')");
			out.println("</script>");
			out.println("</html>");
		} catch (Exception e) {
			// 这里出错不能抛出，否则死循环
		}
	}

}
