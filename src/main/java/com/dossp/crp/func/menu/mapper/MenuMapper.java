/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: MenuMapper.java 
 *
 * @Date:  2016年10月21日  下午12:38:12
 *
 * @Package com.dossp.pms.func.menu.mapper
 */


package com.dossp.crp.func.menu.mapper;

import java.util.List;

import com.dossp.crp.common.mybatis.MyBaseMapper;
import com.dossp.crp.func.menu.model.MenuModel;

/**
 * @author yufenghui
 * </p>
 * 日期：2016年10月21日 下午12:38:12
 * </p>
 * 描述：
 *
 */

public interface MenuMapper extends MyBaseMapper<MenuModel> {

	/** 
	 * 通过userID获取菜单
	 * @param userId
	 * @return 
	 */
	public List<MenuModel> findMenuList(Long userId);

}
