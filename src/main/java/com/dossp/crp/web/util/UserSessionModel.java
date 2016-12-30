/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: UserSessionModel.java 
 *
 * @Date:  2016年10月21日  下午5:34:46
 *
 * @Package com.dossp.cris.web.util
 */


package com.dossp.crp.web.util;

import com.dossp.crp.common.model.BaseModel;


/**
 * @author yufenghui
 * </p>
 * 日期：2016年10月21日 下午5:34:46
 * </p>
 * 描述：
 *
 */

public class UserSessionModel extends BaseModel {

	/** 
	 * 
	 * @Fields serialVersionUID
	 */ 
	private static final long serialVersionUID = -3930443968811897988L;

	private Long id;
	
	private String username;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
}
