/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: SecurityFilter.java 
 *
 * @Date:  2016年11月25日  上午10:36:38
 *
 * @Package com.dossp.pms.web.util
 */


package com.dossp.crp.web.util;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

/**
 * @author yufenghui
 * </p>
 * 日期：2016年11月25日 上午10:36:38
 * </p>
 * 描述：
 *
 */

public class SecurityFilter extends OncePerRequestFilter {

	/** 
	 * @param request
	 * @param response
	 * @param filterChain
	 * @throws ServletException
	 * @throws IOException 
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// 添加X-Frame-Options响应头
		response.setHeader("X-Frame-Options", "SAMEORIGIN");
		// 别忘了这句，否则其他的filter就不执行了
		filterChain.doFilter(request, response);
	}

}
