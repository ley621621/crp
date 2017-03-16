/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: UserRoleService.java 
 *
 * @Date:  2016年10月21日  下午12:31:29
 *
 * @Package com.dossp.pms.func.user.service
 */


package com.dossp.crp.func.user.service;

import java.util.List;

import com.dossp.crp.common.service.BaseService;
import com.dossp.crp.func.user.model.UserRoleModel;

/**
 * @author yufenghui
 * </p>
 * 日期：2016年10月21日 下午12:31:29
 * </p>
 * 描述：
 *
 */

public interface UserRoleService extends BaseService<UserRoleModel, Long> {
	
	public List<UserRoleModel> findUserRole(Long userId);
	
	
	
}
