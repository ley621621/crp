/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: BaseModel.java 
 *
 * @Date:  2016年8月25日  上午9:31:59
 *
 * @Package com.dossp.mcprc.cnm.common.model
 */

package com.dossp.crp.common.model;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

/**
 * @author yufenghui
 *         </p>
 *         日期：2016年8月25日 上午9:31:59
 *         </p>
 *         描述：基础Model类
 *
 */

public abstract class BaseModel implements Serializable {

	/**
	 * 
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = -3245127208178265883L;

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}
