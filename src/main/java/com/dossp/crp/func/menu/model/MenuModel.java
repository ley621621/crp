/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: MenuModel.java 
 *
 * @Date:  2016年10月21日  下午12:37:31
 *
 * @Package com.dossp.pms.func.menu.model
 */


package com.dossp.crp.func.menu.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dossp.crp.common.model.BaseModel;

/**
 * @author yufenghui
 * </p>
 * 日期：2016年10月21日 下午12:37:31
 * </p>
 * 描述：
 *
 */
@Table(name = "func_menu")
public class MenuModel extends BaseModel {

	/** 
	 * 
	 * @Fields serialVersionUID
	 */ 
	private static final long serialVersionUID = 2216548520553679807L;

	/**
     * 菜单主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "id")
    private Long id;
    
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 菜单编码
     */
    private String code;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单地址
     */
    private String url;

    /**
     * 菜单状态 0正常 1禁用
     */
    private String state;

    /**
     * 菜单排序值
     */
    private Long seq;
    
    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 获取菜单主键
     *
     * @return pk_func_menu - 菜单主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置菜单主键
     *
     * @param id 菜单主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取菜单编码
     *
     * @return code - 菜单编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置菜单编码
     *
     * @param code 菜单编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取菜单名称
     *
     * @return name - 菜单名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置菜单名称
     *
     * @param name 菜单名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取菜单地址
     *
     * @return url - 菜单地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置菜单地址
     *
     * @param url 菜单地址
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取菜单状态 0正常 1禁用
     *
     * @return state - 菜单状态 0正常 1禁用
     */
    public String getState() {
        return state;
    }

    /**
     * 设置菜单状态 0正常 1禁用
     *
     * @param state 菜单状态 0正常 1禁用
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 获取菜单排序值
     *
     * @return seq - 菜单排序值
     */
    public Long getSeq() {
        return seq;
    }

    /**
     * 设置菜单排序值
     *
     * @param seq 菜单排序值
     */
    public void setSeq(Long seq) {
        this.seq = seq;
    }

	/**
	 * @return the pkParentMenu
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * @param pkParentMenu the pkParentMenu to set
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * @return the icon
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * @param icon the icon to set
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
}
