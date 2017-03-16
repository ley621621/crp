/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: MenuModel.java 
 *
 * @Date:  2016年11月11日  上午9:19:28
 *
 * @Package com.dossp.pms.func.role.model
 */

package com.dossp.crp.func.role.model;

import java.util.List;

import com.dossp.crp.common.model.BaseModel;
import com.dossp.crp.func.menu.model.MenuModel;

/**
 * @author liuzijian
 *         </p>
 *         日期：2016年11月11日 上午9:19:28
 *         </p>
 *         描述：
 * 
 */

public class Menu extends BaseModel {

	/**
	 * 
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 8163972943508447281L;

	private Integer count;
	private Long menuId;
	private String menuNa;
	private List<MenuModel> menuList;

	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * @param count
	 *            the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	/**
	 * @return the menuId
	 */
	public Long getMenuId() {
		return menuId;
	}

	/**
	 * @param menuId
	 *            the menuId to set
	 */
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	/**
	 * @return the menuNa
	 */
	public String getMenuNa() {
		return menuNa;
	}

	/**
	 * @param menuNa
	 *            the menuNa to set
	 */
	public void setMenuNa(String menuNa) {
		this.menuNa = menuNa;
	}

	/**
	 * @return the menuList
	 */
	public List<MenuModel> getMenuList() {
		return menuList;
	}

	/**
	 * @param menuList
	 *            the menuList to set
	 */
	public void setMenuList(List<MenuModel> menuList) {
		this.menuList = menuList;
	}

}
