/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: UserSessionModel.java 
 *
 * @Date:  2016年10月21日  下午5:34:46
 *
 * @Package com.dossp.cris.web.util
 */

package com.dossp.crp.web.util;

import java.util.List;

import com.dossp.crp.common.model.BaseModel;
import com.dossp.crp.func.menu.model.MenuModel;


/**
 * @author yufenghui </p> 日期：2016年10月21日 下午5:34:46 </p> 描述：
 * 
 */

public class UserSessionModel extends BaseModel {

	/**
	 * 
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = -3930443968811897988L;

	private Long userId;
	private String userNa;

	private Long corpId = 0L;
	private String corpNa;

	private String account;

	private List<MenuModel> menus;

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the corpId
	 */
	public Long getCorpId() {
		return corpId;
	}

	/**
	 * @param corpId
	 *            the corpId to set
	 */
	public void setCorpId(Long corpId) {
		this.corpId = corpId;
	}

	/**
	 * @return the userNa
	 */
	public String getUserNa() {
		return userNa;
	}

	/**
	 * @param userNa
	 *            the userNa to set
	 */
	public void setUserNa(String userNa) {
		this.userNa = userNa;
	}

	/**
	 * @return the corpNa
	 */
	public String getCorpNa() {
		return corpNa;
	}

	/**
	 * @param corpNa
	 *            the corpNa to set
	 */
	public void setCorpNa(String corpNa) {
		this.corpNa = corpNa;
	}

	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * @param account
	 *            the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * @return the menus
	 */
	public List<MenuModel> getMenus() {
		return menus;
	}

	/**
	 * @param menus
	 *            the menus to set
	 */
	public void setMenus(List<MenuModel> menus) {
		this.menus = menus;
	}

}
