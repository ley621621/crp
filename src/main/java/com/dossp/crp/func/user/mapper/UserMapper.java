/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: UserMapper.java 
 *
 * @Date:  2016年10月21日  下午12:28:07
 *
 * @Package com.dossp.pms.func.user.mapper
 */


package com.dossp.crp.func.user.mapper;

import java.util.List;

import com.dossp.crp.common.mybatis.MyBaseMapper;
import com.dossp.crp.func.menu.model.MenuModel;
import com.dossp.crp.func.user.model.UserModel;
import com.dossp.crp.func.user.vo.UserVo;

/**
 * @author yufenghui
 * </p>
 * 日期：2016年10月21日 下午12:28:07
 * </p>
 * 描述：
 *
 */

public interface UserMapper extends MyBaseMapper<UserModel> {

	public List<UserModel> findUserList(UserVo userVo);
	
	/** 
	 * @param account
	 * @return 
	 */
	public UserModel findUserByAccount(String account);
	
	public UserModel findUser(Long userId);

	/** 
	 * @param id
	 * @return 
	 */
	public List<MenuModel> findUserMenuList(Long id);
	
	
	
}
