/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: UserService.java 
 *
 * @Date:  2016年10月21日  下午12:28:22
 *
 * @Package com.dossp.pms.func.user.service
 */


package com.dossp.crp.func.user.service;

import java.util.List;

import com.dossp.crp.common.service.BaseService;
import com.dossp.crp.func.menu.model.MenuModel;
import com.dossp.crp.func.user.model.UserModel;
import com.dossp.crp.func.user.vo.UserVo;
import com.github.pagehelper.PageInfo;

/**
 * @author yufenghui
 * </p>
 * 日期：2016年10月21日 下午12:28:22
 * </p>
 * 描述：
 *
 */

public interface UserService extends BaseService<UserModel, Long> {
	
	public PageInfo<UserModel> findPageInfo(UserVo userVo);
	
	public UserModel findUser(Long userId);

	/** 
	 * @param account
	 * @return 
	 */
	public UserModel findUserByAccount(String account);

	/** 
	 * @param userId
	 * @return 
	 */
	public List<MenuModel> findUserMenuList(Long userId);
	
	public int saveUser(UserModel userModel, String[] roleList);
	
	public int updateUser(Long id, String[] roleList);
	
	public int resetPwd(UserModel userModel);

	public int deleteUser(UserModel userModel);

}
