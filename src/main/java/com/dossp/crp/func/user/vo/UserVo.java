/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: UserVo.java 
 *
 * @Date:  2016年10月22日  下午4:01:15
 *
 * @Package com.dossp.pms.func.user.vo
 */


package com.dossp.crp.func.user.vo;

import com.dossp.crp.common.vo.BaseVo;

/**
 * @author shaoyingjie
 * </p>
 * 日期：2016年10月22日 下午4:01:15
 * </p>
 * 描述：
 *
 */

public class UserVo extends BaseVo{

	/** 
	 * 
	 * @Fields serialVersionUID
	 */ 
	private static final long serialVersionUID = 7405687823320850043L;
	
	private Long corpId;
	
	private Long unitId;
	
	private Long deptId;
	
	private String name;
	
	private String account;
	
	private Long roleId;

	public Long getCorpId() {
		return corpId;
	}

	public void setCorpId(Long corpId) {
		this.corpId = corpId;
	}

	public Long getUnitId() {
		return unitId;
	}

	public void setUnitId(Long unitId) {
		this.unitId = unitId;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	
	

}
