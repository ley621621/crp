/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: DeptVo.java 
 *
 * @Date:  2016年10月25日  上午10:07:51
 *
 * @Package com.dossp.pms.dict.dept.vo
 */


package com.dossp.crp.dict.dept.vo;

import com.dossp.crp.common.vo.BaseVo;

/**
 * @author renyajie
 * </p>
 * 日期：2016年10月25日 上午10:07:51
 * </p>
 * 描述：
 *
 */

public class DeptVo extends BaseVo {

	/** 
	 * 
	 * @Fields serialVersionUID :
	 */ 
	private static final long serialVersionUID = -4217220518471114125L;
	
	   /**
     * 业务单元
     */
    private String corp;
    
    /**
     * 部门名称
     */
    private String name;
    
    /**
     * 部门ID
     */
    private Long pkDicDept;
    
	/**
     * 专业化公司
     */
    private String corpParent;
    
    /**
     * 业务单元ID
     */
    private Long corpId;
    
    /**
     * 专业化公司ID
     */
    private Long corpParentId;
    
	/**
	 * @return the pkDicDept
	 */
	public Long getPkDicDept() {
		return pkDicDept;
	}

	/**
	 * @param pkDicDept the pkDicDept to set
	 */
	public void setPkDicDept(Long pkDicDept) {
		this.pkDicDept = pkDicDept;
	}

	/**
	 * @return the corpId
	 */
	public Long getCorpId() {
		return corpId;
	}

	/**
	 * @param corpId the corpId to set
	 */
	public void setCorpId(Long corpId) {
		this.corpId = corpId;
	}

	/**
	 * @return the corpParentId
	 */
	public Long getCorpParentId() {
		return corpParentId;
	}

	/**
	 * @param corpParentId the corpParentId to set
	 */
	public void setCorpParentId(Long corpParentId) {
		this.corpParentId = corpParentId;
	}

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

	/**
	 * @return the corp
	 */
	public String getCorp() {
		return corp;
	}

	/**
	 * @param corp the corp to set
	 */
	public void setCorp(String corp) {
		this.corp = corp;
	}

	/**
	 * @return the corpParent
	 */
	public String getCorpParent() {
		return corpParent;
	}

	/**
	 * @param corpParent the corpParent to set
	 */
	public void setCorpParent(String corpParent) {
		this.corpParent = corpParent;
	}
}
