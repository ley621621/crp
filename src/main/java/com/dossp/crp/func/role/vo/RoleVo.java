/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: RoleVo.java 
 *
 * @Date:  2016年10月24日  上午10:42:33
 *
 * @Package com.dossp.pms.func.role.vo
 */


package com.dossp.crp.func.role.vo;

import com.dossp.crp.common.vo.BaseVo;

/**
 * @author shaoyingjie
 * </p>
 * 日期：2016年10月24日 上午10:42:33
 * </p>
 * 描述：
 *
 */

public class RoleVo extends BaseVo{
	
	/** 
	 * 
	 * @Fields serialVersionUID
	 */ 
	private static final long serialVersionUID = -2488682433213006321L;

	private Long pkFuncRole;

    /**
     * 角色编码
     */
    private String code;

    /**
     * 角色名称
     */
    private String name;

	public Long getPkFuncRole() {
		return pkFuncRole;
	}

	public void setPkFuncRole(Long pkFuncRole) {
		this.pkFuncRole = pkFuncRole;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
    

}
