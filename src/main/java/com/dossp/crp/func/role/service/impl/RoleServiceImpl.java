/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: RoleServiceImpl.java 
 *
 * @Date:  2016年10月21日  下午12:34:10
 *
 * @Package com.dossp.pms.func.role.service.impl
 */


package com.dossp.crp.func.role.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dossp.crp.common.service.impl.BaseServiceImpl;
import com.dossp.crp.func.menu.mapper.MenuMapper;
import com.dossp.crp.func.menu.model.MenuModel;
import com.dossp.crp.func.role.mapper.RoleMapper;
import com.dossp.crp.func.role.mapper.RoleMenuMapper;
import com.dossp.crp.func.role.model.Menu;
import com.dossp.crp.func.role.model.RoleMenuModel;
import com.dossp.crp.func.role.model.RoleModel;
import com.dossp.crp.func.role.service.RoleService;
import com.dossp.crp.func.role.vo.RoleVo;
import com.dossp.crp.func.user.mapper.UserRoleMapper;
import com.dossp.crp.func.user.model.UserRoleModel;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;


/**
 * @author yufenghui
 * </p>
 * 日期：2016年10月21日 下午12:34:10
 * </p>
 * 描述：
 *
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<RoleModel, Long> implements RoleService {
	
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private MenuMapper menuMapper;
	@Autowired
	private RoleMenuMapper roleMenuMapper;
	@Autowired
	private UserRoleMapper userRoleMapper;

	/** 
	 * @param roleModel
	 * @return 
	 */
	@Override
	public PageInfo<RoleModel> findRolePage(RoleVo roleVo) {
		Example example =  new Example(RoleModel.class);
		Criteria criteria = example.createCriteria();
		if(StringUtils.isNotBlank(roleVo.getName())) {
			criteria.andLike("name", "%"+roleVo.getName()+"%");
		}
		if(StringUtils.isNotBlank(roleVo.getCode())) {
			criteria.andLike("code", "%"+roleVo.getCode()+"%");
		}
		PageHelper.startPage(roleVo.getPageNum(), roleVo.getPageSize());
		List<RoleModel> list = roleMapper.selectByExample(example);
		return new PageInfo<RoleModel>(list);
	}

	
	@Override
	public List<RoleModel> findUserRoleNot(Long userId) {
		List<RoleModel> roleList = roleMapper.findUserRoleNot(userId);
		return roleList;
	}


	/** 
	 * @return 
	 */
	
	
	@Override
	public List<RoleModel> findRoleList() {
		Example example =  new Example(RoleModel.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", "0");
		List<RoleModel> roleList = roleMapper.selectByExample(example);
		return roleList;
	}


	/** 
	 * @return 
	 */
	@Override
	public List<Menu> findMenuList() {
		Example example =  new Example(MenuModel.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", "0");
		criteria.andEqualTo("parentId", "0");
		example.orderBy("seq").asc();
		
		List<MenuModel> list = menuMapper.selectByExample(example);
		
		List<Menu> menuList = new ArrayList<Menu>();
		
		for (int i = 0; i < list.size(); i++) {
			Menu menu = new Menu();
			MenuModel menuModel = list.get(i);
			List<MenuModel> menus = findMenuList(menuModel.getId());
			
			menu.setMenuList(menus);
			menu.setCount(menus.size());
			menu.setMenuId(menuModel.getId());
			menu.setMenuNa(menuModel.getName());
			
			menuList.add(menu);
		}
				
		return menuList;
	}
	private List<MenuModel> findMenuList(Long parentId){
		Example example =  new Example(MenuModel.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", "0");
		criteria.andEqualTo("parentId", parentId);
		example.orderBy("seq").asc();
		
		return menuMapper.selectByExample(example);
	}


	/** 
	 * @param roleId
	 * @param menuIds
	 * @return 
	 */
	@Override
	@Transactional
	public boolean setMenu(String roleId, String[] menuIds) {
		boolean result = true;
		Example example = new Example(RoleMenuModel.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("roleId", roleId);
		
		roleMenuMapper.deleteByExample(example);
		
		for (int i = 0; i < menuIds.length; i++) {
			RoleMenuModel roleMenu = new RoleMenuModel();
			
			roleMenu.setRoleId(Long.parseLong(roleId));
			roleMenu.setMenuId(Long.parseLong(menuIds[i]));
			
			int ret = roleMenuMapper.insert(roleMenu);
			
			if(ret <= 0){
				result = false;
				break;
			}
		}
		
		return result;
	}


	/** 
	 * @param roleId
	 * @return 
	 */
	@Override
	public Map<Long, Long> findMenuMap(Long roleId) {
		Example example =  new Example(RoleMenuModel.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("roleId", roleId);
		
		List<RoleMenuModel> roleMenuList = roleMenuMapper.selectByExample(example);
		
		Map<Long, Long> map = new HashMap<Long, Long>();
		
		for (int i = 0; i < roleMenuList.size(); i++) {
			RoleMenuModel roleMenu = roleMenuList.get(i);
			map.put(roleMenu.getMenuId(), roleId);
		}
		
		return map;
	}


	/** 
	 * 更新角色禁用启用角色
	 * @param roleId
	 * @return 
	 */
	@Override
	@Transactional
	public int updateRoleState(Long roleId, String state) {
		
		RoleModel role = roleMapper.selectByPrimaryKey(roleId);
		role.setState(state);
		
		return roleMapper.updateByPrimaryKey(role);
	}


	/** 
	 * 删除角色同时删除角色与用户、菜单关系表
	 * @param roleId
	 * @return 
	 */
	@Override
	@Transactional
	public int deleteRole(Long roleId) {
		int result = 0;
		
		try{
			//删除角色信息
			int num = roleMapper.deleteByPrimaryKey(roleId);
			if(num > 0){
				result = num;
			}
			
			Example example = new Example(UserRoleModel.class);
			Criteria criteria = example.createCriteria();
			criteria.andEqualTo("roleId", roleId);
			
			//删除角色与用户信息
			num = userRoleMapper.deleteByExample(example);
			if(num > 0){
				result = num;
			}
			//删除角色与菜单信息
			num = roleMenuMapper.deleteByExample(example);
			if(num > 0){
				result = num;
			}
		}catch (Exception e) {
			result = 0;
		}
		return result;
	}
}
