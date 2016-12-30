/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: SampleVo.java 
 *
 * @Date:  2016年12月30日  下午3:35:39
 *
 * @Package com.dossp.crp.sample.vo
 */


package com.dossp.crp.sample.vo;

import com.dossp.crp.common.vo.BaseVo;

/**
 * @author yufenghui
 * </p>
 * 日期：2016年12月30日 下午3:35:39
 * </p>
 * 描述：
 *
 */

public class SampleVo extends BaseVo {
	
	/** 
	 * 
	 * @Fields serialVersionUID
	 */ 
	private static final long serialVersionUID = 9024571188485830352L;
	
	private String name;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
