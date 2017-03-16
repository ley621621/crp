/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: MenuTree.java 
 *
 * @Date:  2016年11月10日  下午4:13:09
 *
 * @Package com.dossp.pms.func.menu.model
 */

package com.dossp.crp.func.menu.model;

import com.dossp.crp.common.model.BaseModel;

/**
 * @author liuzijian </p> 日期：2016年11月10日 下午4:13:09 </p> 描述：
 * 
 */

public class MenuTree extends BaseModel {
	/**
	 * 
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 2261194750227133957L;

	private Long id;
	private Long pId;
	private String name;
	private String click;
	private boolean open;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the pId
	 */
	public Long getpId() {
		return pId;
	}

	/**
	 * @param pId
	 *            the pId to set
	 */
	public void setpId(Long pId) {
		this.pId = pId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the click
	 */
	public String getClick() {
		return click;
	}

	/**
	 * @param click
	 *            the click to set
	 */
	public void setClick(String click) {
		this.click = click;
	}

	/**
	 * @return the open
	 */
	public boolean isOpen() {
		return open;
	}

	/**
	 * @param open
	 *            the open to set
	 */
	public void setOpen(boolean open) {
		this.open = open;
	}

}
