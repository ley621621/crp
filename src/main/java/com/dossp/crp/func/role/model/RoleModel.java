/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: RoleModel.java 
 *
 * @Date:  2016年10月21日  下午12:32:42
 *
 * @Package com.dossp.pms.func.role.model
 */


package com.dossp.crp.func.role.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dossp.crp.common.model.BaseModel;

/**
 * @author yufenghui
 * </p>
 * 日期：2016年10月21日 下午12:32:42
 * </p>
 * 描述：
 *
 */
@Table(name = "func_role")
public class RoleModel extends BaseModel {

	/** 
	 * 
	 * @Fields serialVersionUID
	 */ 
	private static final long serialVersionUID = -7973557197536379223L;

	/**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "id")
    private Long id;

    /**
     * 角色编码
     */
    private String code;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 状态 0正常 1禁用
     */
    private String state;

    /**
     * 获取主键
     *
     * @return pk_func_role - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param pkFuncRole 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取角色编码
     *
     * @return code - 角色编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置角色编码
     *
     * @param code 角色编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取角色名称
     *
     * @return name - 角色名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置角色名称
     *
     * @param name 角色名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取状态 0正常 1禁用
     *
     * @return state - 状态 0正常 1禁用
     */
    public String getState() {
        return state;
    }

    /**
     * 设置状态 0正常 1禁用
     *
     * @param state 状态 0正常 1禁用
     */
    public void setState(String state) {
        this.state = state;
    }
    
}
