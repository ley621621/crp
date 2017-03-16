/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: RoleMapper.java 
 *
 * @Date:  2016年10月21日  下午12:33:22
 *
 * @Package com.dossp.pms.func.role.mapper
 */


package com.dossp.crp.func.role.mapper;

import java.util.List;

import com.dossp.crp.common.mybatis.MyBaseMapper;
import com.dossp.crp.func.role.model.RoleModel;

/**
 * @author yufenghui
 * </p>
 * 日期：2016年10月21日 下午12:33:22
 * </p>
 * 描述：
 *
 */

public interface RoleMapper extends MyBaseMapper<RoleModel> {
	
	public List<RoleModel> findUserRoleNot(Long userId);

}
