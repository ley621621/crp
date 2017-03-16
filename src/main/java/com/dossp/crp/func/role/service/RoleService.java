/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: RoleService.java 
 *
 * @Date:  2016年10月21日  下午12:33:35
 *
 * @Package com.dossp.pms.func.role.service
 */


package com.dossp.crp.func.role.service;

import java.util.List;
import java.util.Map;

import com.dossp.crp.common.service.BaseService;
import com.dossp.crp.func.role.model.Menu;
import com.dossp.crp.func.role.model.RoleModel;
import com.dossp.crp.func.role.vo.RoleVo;
import com.github.pagehelper.PageInfo;

/**
 * @author yufenghui
 * </p>
 * 日期：2016年10月21日 下午12:33:35
 * </p>
 * 描述：
 *
 */

public interface RoleService extends BaseService<RoleModel, Long> {
	
	public PageInfo<RoleModel> findRolePage(RoleVo roleVo);
	
	public List<RoleModel> findUserRoleNot(Long userId);
	
	public List<RoleModel> findRoleList();

	/** 
	 * 所有菜单列表
	 * @return 
	 */
	public List<Menu> findMenuList();

	/** 
	 * 保存权限
	 * @param roleId
	 * @param menuIds
	 * @return 
	 */
	public boolean setMenu(String roleId, String[] menuIds);

	/** 
	 * 获取通过角色获取已分配的菜单
	 * @param roleId
	 * @return 
	 */
	public Map<Long, Long> findMenuMap(Long roleId);

	/** 
	 * 更新角色禁用启用状态
	 * @param roleId
	 * @return 
	 */
	public int updateRoleState(Long roleId, String state);

	/** 
	 * 通过主键ID删除角色及角色与用户、菜单关系表
	 * @param roleId
	 * @return 
	 */
	public int deleteRole(Long roleId);
	
}
