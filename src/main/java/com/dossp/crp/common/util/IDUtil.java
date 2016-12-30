/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: IDUtil.java 
 *
 * @Date:  2016年9月6日  上午9:19:43
 *
 * @Package com.dossp.ods.dms.common.util
 */

package com.dossp.crp.common.util;

import java.util.UUID;

/**
 * @author yufenghui
 *         </p>
 *         日期：2016年9月6日 上午9:19:43
 *         </p>
 *         描述：
 *
 */

public final class IDUtil {

	private IDUtil() {
	}

	/**
	 * 返回随机32位UUID
	 * 
	 * @return
	 */
	public static String uuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

}
