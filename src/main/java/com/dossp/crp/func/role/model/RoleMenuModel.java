/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: RoleMeunModel.java 
 *
 * @Date:  2016年10月21日  下午12:34:53
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
 * 日期：2016年10月21日 下午12:34:53
 * </p>
 * 描述：
 *
 */
@Table(name = "func_role_menu")
public class RoleMenuModel extends BaseModel {

	/** 
	 * 
	 * @Fields serialVersionUID
	 */ 
	private static final long serialVersionUID = 7476720294108783209L;

	/**
     * 角色菜单关系表主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "id")
    private Long id;

    /**
     * 角色主键
     */
    @Column(name = "role_id")
    private Long roleId;

    /**
     * 菜单主键
     */
    @Column(name = "menu_id")
    private Long menuId;

    /**
     * 获取角色菜单关系表主键
     *
     * @return pk_func_role_meun - 角色菜单关系表主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置角色菜单关系表主键
     *
     * @param pkFuncRoleMeun 角色菜单关系表主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取角色主键
     *
     * @return pk_func_role - 角色主键
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 设置角色主键
     *
     * @param pkFuncRole 角色主键
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取菜单主键
     *
     * @return pk_func_meun - 菜单主键
     */
    public Long getMenuId() {
        return menuId;
    }

    /**
     * 设置菜单主键
     *
     * @param pkFuncMeun 菜单主键
     */
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
    
}
