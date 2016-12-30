/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: SpringEncryptUtil.java 
 *
 * @Date:  2016年8月26日  下午4:08:06
 *
 * @Package com.dossp.mcprc.cnm.common.util
 */

package com.dossp.crp.common.util;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

/**
 * @author yufenghui
 *         </p>
 *         日期：2016年8月26日 下午4:08:06
 *         </p>
 *         描述：
 *
 */

public final class SpringEncryptUtil {

	private static final PasswordEncoder passwordEncoder = new StandardPasswordEncoder();

	private SpringEncryptUtil() {
	}

	/**
	 * 对原始密码进行加密
	 * 
	 * @param rawPassword
	 * @return
	 */
	public static String encrypt(String rawPassword) {
		return passwordEncoder.encode(rawPassword);
	}

	/**
	 * 对密码进行匹配，验证
	 * 
	 * @param rawPassword
	 *            用户输入的原始验证密码
	 * @param password
	 *            数据库中存储的加密后的密码
	 * @return
	 */
	public static boolean match(String rawPassword, String password) {
		return passwordEncoder.matches(rawPassword, password);
	}

}
