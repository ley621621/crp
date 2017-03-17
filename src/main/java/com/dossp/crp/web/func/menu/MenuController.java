/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: MenuController.java 
 *
 * @Date:  2016年10月24日  下午12:33:10
 *
 * @Package com.dossp.pms.web.func.menu
 */


package com.dossp.crp.web.func.menu;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dossp.crp.common.model.JsonMsg;
import com.dossp.crp.func.menu.model.MenuModel;
import com.dossp.crp.func.menu.service.MenuService;
import com.dossp.crp.func.menu.vo.MenuVo;
import com.github.pagehelper.PageInfo;

/**
 * @author shaoyingjie
 * </p>
 * 日期：2016年10月24日 下午12:33:10
 * </p>
 * 描述：
 *
 */
@Controller
@RequestMapping("/func/menu")
public class MenuController {
	
	private static final Logger log = LoggerFactory.getLogger(MenuController.class);
	
	@Autowired
	private MenuService menuService;
	
	/**
	 * 跳转菜单列表
	 * @param request
	 * @param menuVo
	 * @return
	 */
	@RequestMapping("to_menu_list")
	public String to_menu_list(HttpServletRequest request,MenuVo menuVo){
		PageInfo<MenuModel> pageInfo = menuService.findMenuPage(menuVo);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("vo", menuVo);
		return "func/menu/menu_list";
	}
	/**
	 * 跳转新增页面
	 * @param request
	 * @return
	 */
	@RequestMapping("to_add_menu")
	public String toAddMenu(HttpServletRequest request, Long pId){
		request.setAttribute("pId", pId);
		return "func/menu/add_menu";
	}
	
	@RequestMapping(value = "to_menu")
	public String toMenu(){
		
		return "func/menu/menu";
	}
	
	@RequestMapping(value = "to_tree")
	public String toTree(HttpServletRequest reqeust){
		String tree = menuService.findMenuTree();
		
		reqeust.setAttribute("tree", tree);
		
		return "func/menu/tree";
	}
	
	/**
	 * 新增菜单
	 * @param menuModel
	 * @return
	 */
	@RequestMapping("do_add_menu")
	@ResponseBody
	public JsonMsg doAddMenu(MenuModel menuModel){
		JsonMsg ret = new JsonMsg("操作失败!");
		try{
			int flag = menuService.insert(menuModel);
			if(flag > 0){
				ret.setSuccess(true);
				ret.setMsg("操作成功!");
			}
		}catch(Exception e){
			ret.setSuccess(false);
			ret.setMsg("操作失败!");
			log.error("操作失败!", e);
		}
		return ret;
	}
	/**
	 * 跳转编辑页面
	 * @param request
	 * @param menuId
	 * @return
	 */
	@RequestMapping("to_update_menu")
	public String toUpdateMenu(HttpServletRequest request,Long menuId){
		MenuModel model = menuService.selectById(menuId);
		request.setAttribute("model", model);
		return "func/menu/update_menu";
	}
	/**
	 * 编辑菜单
	 * @param menuModel
	 * @return
	 */
	@RequestMapping("do_update_menu")
	@ResponseBody
	public JsonMsg doUpdateMenu(MenuModel menuModel){
		JsonMsg ret = new JsonMsg("操作失败!");
		try{
			int flag = menuService.update(menuModel);
			if(flag > 0){
				ret.setSuccess(true);
				ret.setMsg("操作成功!");
			}
		}catch(Exception e){
			ret.setSuccess(false);
			ret.setMsg("操作失败!");
			log.error("操作失败!", e);
		}
		return ret;
	}
	
	/**
	 * 菜单启用禁用
	 * @param menuModel
	 * @return
	 */
	@RequestMapping("update_state")
	@ResponseBody
	public JsonMsg updateState(MenuModel menuModel){
		JsonMsg msg = new JsonMsg("");
		try {
			int result = menuService.update(menuModel);
			if(result > 0){
				msg.setSuccess(true);
				if("0".equals(menuModel.getState())){
					msg.setMsg("启用成功!");
				}else if("1".equals(menuModel.getState())){
					msg.setMsg("禁用成功!");
				}
			}
		} catch (Exception e) {
			msg.setSuccess(false);
		}
		return msg;
	}

	/**
	 * 删除菜单
	 * @param menuModel
	 * @return
	 */
	@RequestMapping("do_delete_menu")
	@ResponseBody
	public JsonMsg doDeleteMenu(MenuModel menuModel){
		JsonMsg ret = new JsonMsg("操作失败!");
		try{
			int flag = menuService.deleteMenu(menuModel);
			if(flag > 0){
				ret.setSuccess(true);
				ret.setMsg("操作成功!");
			}
		}catch(Exception e){
			ret.setSuccess(false);
			ret.setMsg("操作失败!");
			log.error("操作失败!", e);
		}
		return ret;
	}

}
