/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: MenuVo.java 
 *
 * @Date:  2016年10月24日  下午12:30:05
 *
 * @Package com.dossp.pms.func.menu.vo
 */


package com.dossp.crp.func.menu.vo;

import com.dossp.crp.common.vo.BaseVo;

/**
 * @author shaoyingjie
 * </p>
 * 日期：2016年10月24日 下午12:30:05
 * </p>
 * 描述：
 *
 */

public class MenuVo extends BaseVo{
	
	/** 
	 * 
	 * @Fields serialVersionUID
	 */ 
	private static final long serialVersionUID = 7127481768120057703L;

	private String code;

    /**
     * 菜单名称
     */
    private String name;

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
