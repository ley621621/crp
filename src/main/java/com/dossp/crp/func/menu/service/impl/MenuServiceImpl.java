/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: MenuServiceImpl.java 
 *
 * @Date:  2016年10月21日  下午12:38:53
 *
 * @Package com.dossp.pms.func.menu.service.impl
 */


package com.dossp.crp.func.menu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.dossp.crp.common.service.impl.BaseServiceImpl;
import com.dossp.crp.func.menu.mapper.MenuMapper;
import com.dossp.crp.func.menu.model.MenuModel;
import com.dossp.crp.func.menu.model.MenuTree;
import com.dossp.crp.func.menu.service.MenuService;
import com.dossp.crp.func.menu.vo.MenuVo;
import com.dossp.crp.func.role.mapper.RoleMenuMapper;
import com.dossp.crp.func.role.model.RoleMenuModel;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * @author yufenghui
 * </p>
 * 日期：2016年10月21日 下午12:38:53
 * </p>
 * 描述：
 *
 */
@Service
public class MenuServiceImpl extends BaseServiceImpl<MenuModel, Long> implements MenuService {
	@Autowired
	private MenuMapper menuMapper;
	@Autowired
	private RoleMenuMapper roleMenuMapper;
	
	private static final Logger log = LoggerFactory.getLogger(MenuServiceImpl.class);

	/** 
	 * @param menuVo
	 * @return 
	 */
	
	
	@Override
	public PageInfo<MenuModel> findMenuPage(MenuVo menuVo) {
		Example example =  new Example(MenuModel.class);
		Criteria criteria = example.createCriteria();
		if(StringUtils.isNotBlank(menuVo.getName())) {
			criteria.andLike("name", "%"+menuVo.getName()+"%");
		}
		if(StringUtils.isNotBlank(menuVo.getCode())) {
			criteria.andLike("code", "%"+menuVo.getCode()+"%");
		}
		PageHelper.startPage(menuVo.getPageNum(), menuVo.getPageSize());
		List<MenuModel> list = menuMapper.selectByExample(example);
		return new PageInfo<MenuModel>(list);
	}

	/** 
	 * @return 
	 */
	@Override
	public String findMenuTree() {
		Example example =  new Example(MenuModel.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", "0");
		example.orderBy("seq").asc();
		
		List<MenuModel> menuList = menuMapper.selectByExample(example);
		List<MenuTree> treeList = new ArrayList<MenuTree>();
		
		MenuTree tree = new MenuTree();
		tree.setOpen(true);
		tree.setName("父级菜单");
		tree.setId(0L);
		tree.setpId(-1L);
		tree.setClick("_toAddMenu('0')");
		treeList.add(tree);
		
		for (int i = 0; i < menuList.size(); i++) {
			tree = new MenuTree();
			MenuModel menu = menuList.get(i);
			
			tree.setOpen(false);
			tree.setName(menu.getName());
			tree.setId(menu.getId());
			tree.setpId(menu.getParentId());
			if(menu.getParentId() == 0L){
				tree.setClick("_toAddMenu('"+menu.getId()+"')");
			}
			treeList.add(tree);
		}
		
		return JSON.toJSONString(treeList);
	}

	/** 
	 * @param menuId
	 * @return 
	 */
	@Override
	@Transactional
	public int deleteMenu(Long menuId) {
		int result = 0;
		try{
			Example example = new Example(MenuModel.class);
			Criteria criteria = example.createCriteria();
			criteria.andEqualTo("parentId", menuId);
			//获取一级菜单下所有二级菜单并删除
			List<MenuModel> menuList = menuMapper.selectByExample(example);
			//如果menuList大于0，则需要删除所属的二级菜单
			if(menuList.size() > 0L){
				//删除一级菜单
				result = menuMapper.deleteByPrimaryKey(menuId);
				if(result > 0){
					//删除二级菜单
					for (int i = 0; i < menuList.size(); i++) {
						MenuModel subMenu = menuList.get(i);
						//删除菜单与角色关系表数据
						result = deleteRoleMenu(subMenu.getId());
						if(result > 0){
							result = menuMapper.deleteByPrimaryKey(subMenu.getId());
						}
					}
				}
			}else{
				//删除菜单数据
				result = menuMapper.deleteByPrimaryKey(menuId);
				if(result > 0){
					result = deleteRoleMenu(menuId);
				}
			}
		}catch (Exception e) {
			result = 0;
			log.info(e.getMessage());
		}
		return result;
	}
	/**
	 * 通过菜单ID删除角色与菜单关系表数据
	 * @param menuId
	 * @return
	 */
	private int deleteRoleMenu(Long menuId){
		Example example = new Example(RoleMenuModel.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("menuId", menuId);
		//删除菜单与角色关系表数据
		return roleMenuMapper.deleteByExample(example);
	}

	/** 
	 * 通过登陆用户获取登陆用户角色
	 * @param userId
	 * @return 
	 */
	@Override
	public List<MenuModel> findMenuList(Long userId) {
		return menuMapper.findMenuList(userId);
	}

	/** 
	 * 更新菜单状态
	 * @param state
	 * @param menuId
	 * @return 
	 */
	@Override
	public int updateMenuState(String state, Long menuId) {
		
		MenuModel menu = menuMapper.selectByPrimaryKey(menuId);
		menu.setState(state);
		
		return menuMapper.updateByPrimaryKey(menu);
	}

	@Transactional
	@Override
	public int deleteMenu(MenuModel menuModel) {
		int result = 0;
		int ret = menuMapper.delete(menuModel);
		result = ret;
		if(ret > 0){
			Example example = new Example(RoleMenuModel.class);
			Criteria criteria = example.createCriteria();
			criteria.andEqualTo("menuId", menuModel.getId());
			List<RoleMenuModel> list = roleMenuMapper.selectByExample(example);
			if(list != null && list.size() != 0){
				result = roleMenuMapper.deleteByExample(example);
			}
		}
		return result;
	}

}
