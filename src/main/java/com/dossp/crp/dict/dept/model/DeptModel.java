/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: DeptModel.java 
 *
 * @Date:  2016年10月21日  下午12:21:29
 *
 * @Package com.dossp.pms.dict.dept.model
 */


package com.dossp.crp.dict.dept.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.dossp.crp.common.model.BaseModel;

/**
 * @author yufenghui
 * </p>
 * 日期：2016年10月21日 下午12:21:29
 * </p>
 * 描述：
 *
 */
@Table(name = "dic_dept")
public class DeptModel extends BaseModel {

	/** 
	 * 
	 * @Fields serialVersionUID
	 */ 
	private static final long serialVersionUID = 8106649453191697225L;

	/**
     * 部门主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "pk_dic_dept")
    private Long pkDicDept;

    /**
     * 组织机构主键
     */
    @Column(name = "pk_sys_corp")
    private Long pkSysCorp;

    /**
     * 部门编码
     */
    private String code;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 部门状态 0正常 1禁用
     */
    private String state;
    
    /**
     * 业务单元
     */
    @Transient
    private String corp;
    
    /**
     * 专业化公司
     */
    @Transient
    private String corpParent;
    
    /**
     * 业务单元ID
     */
    @Transient
    private Long corpId;
    
    /**
     * 专业化公司ID
     */
    @Transient
    private Long corpParentId;
    
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

	/**
     * 获取部门主键
     *
     * @return pk_dic_dept - 部门主键
     */
    public Long getPkDicDept() {
        return pkDicDept;
    }

    /**
     * 设置部门主键
     *
     * @param pkDicDept 部门主键
     */
    public void setPkDicDept(Long pkDicDept) {
        this.pkDicDept = pkDicDept;
    }

    /**
     * 获取组织机构主键
     *
     * @return pk_sys_corp - 组织机构主键
     */
    public Long getPkSysCorp() {
        return pkSysCorp;
    }

    /**
     * 设置组织机构主键
     *
     * @param pkSysCorp 组织机构主键
     */
    public void setPkSysCorp(Long pkSysCorp) {
        this.pkSysCorp = pkSysCorp;
    }

    /**
     * 获取部门编码
     *
     * @return code - 部门编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置部门编码
     *
     * @param code 部门编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取部门名称
     *
     * @return name - 部门名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置部门名称
     *
     * @param name 部门名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取部门状态 0正常 1禁用
     *
     * @return state - 部门状态 0正常 1禁用
     */
    public String getState() {
        return state;
    }

    /**
     * 设置部门状态 0正常 1禁用
     *
     * @param state 部门状态 0正常 1禁用
     */
    public void setState(String state) {
        this.state = state;
    }
    
    
    
}
