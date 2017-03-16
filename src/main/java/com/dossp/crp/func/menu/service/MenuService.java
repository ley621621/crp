/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: MenuService.java 
 *
 * @Date:  2016年10月21日  下午12:38:29
 *
 * @Package com.dossp.pms.func.menu.service
 */


package com.dossp.crp.func.menu.service;


import java.util.List;

import com.dossp.crp.common.service.BaseService;
import com.dossp.crp.func.menu.model.MenuModel;
import com.dossp.crp.func.menu.vo.MenuVo;
import com.github.pagehelper.PageInfo;

/**
 * @author yufenghui
 * </p>
 * 日期：2016年10月21日 下午12:38:29
 * </p>
 * 描述：
 *
 */

public interface MenuService extends BaseService<MenuModel, Long> {
	
	public PageInfo<MenuModel> findMenuPage(MenuVo menuVo);

	/** 
	 * 获取菜单树
	 * @return 
	 */
	public String findMenuTree();

	/** 
	 * 通过菜单ID删除菜单，及菜单与角色关系表
	 * @param menuId
	 * @return 
	 */
	public int deleteMenu(Long menuId);

	/** 
	 * 通过登陆用户获取登陆用户菜单
	 * @param id
	 * @return 
	 */
	public List<MenuModel> findMenuList(Long userId);

	/** 
	 * 更新菜单状态
	 * @param state
	 * @param menuId
	 * @return 
	 */
	public int updateMenuState(String state, Long menuId);

}
