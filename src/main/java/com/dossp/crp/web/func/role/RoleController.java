/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: RoleController.java 
 *
 * @Date:  2016年10月24日  上午10:39:16
 *
 * @Package com.dossp.pms.web.func.role
 */


package com.dossp.crp.web.func.role;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dossp.crp.common.model.JsonMsg;
import com.dossp.crp.func.role.model.Menu;
import com.dossp.crp.func.role.model.RoleModel;
import com.dossp.crp.func.role.service.RoleService;
import com.dossp.crp.func.role.vo.RoleVo;
import com.github.pagehelper.PageInfo;

/**
 * @author shaoyingjie
 * </p>
 * 日期：2016年10月24日 上午10:39:16
 * </p>
 * 描述：
 *
 */

@Controller
@RequestMapping("/func/role")
public class RoleController {
	private static final Logger log = LoggerFactory.getLogger(RoleController.class);
	
	@Autowired
	private RoleService roleService;
	
	/**
	 * 跳转列表页面
	 * @param request
	 * @param roleVo
	 * @return
	 */
	@RequestMapping("to_role_list")
	public String to_role_list(HttpServletRequest request,RoleVo roleVo){
		
		PageInfo<RoleModel> pageInfo = roleService.findRolePage(roleVo);
		
		request.setAttribute("vo", roleVo);
		request.setAttribute("pageInfo", pageInfo);
		
		return "func/role/role_list";
	}
	/**
	 * 跳转新增页面
	 * @param request
	 * @return
	 */
	@RequestMapping("to_add_role")
	public String toAddRole(HttpServletRequest request){
		return "func/role/add_role";
	}
	
	/**
	 * 新增角色
	 * @param roleModel
	 * @return
	 */
	@RequestMapping("do_add_role")
	@ResponseBody
	public JsonMsg doAddRole(RoleModel roleModel){
		JsonMsg ret = new JsonMsg("操作失败!");
		try{
			int flag = roleService.insert(roleModel);
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
	 * @param roleId
	 * @return
	 */
	@RequestMapping("to_update_role")
	public String toUpdateMenu(HttpServletRequest request,Long roleId){
		
		RoleModel model = roleService.selectById(roleId);
		
		request.setAttribute("model", model);
		
		return "func/role/update_role";
	}
	/**
	 * 编辑角色
	 * @param roleModel
	 * @return
	 */
	@RequestMapping("do_update_role")
	@ResponseBody
	public JsonMsg doUpdateRole(RoleModel roleModel){
		JsonMsg ret = new JsonMsg("操作失败!");
		try{
			int flag = roleService.update(roleModel);
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
	 * 角色启用禁用
	 * @param roleModel
	 * @return
	 */
	@RequestMapping("update_state")
	@ResponseBody
	public JsonMsg updateState(RoleModel roleModel){
		JsonMsg msg = new JsonMsg("操作失败!");
		try {
			int result = roleService.update(roleModel);
			if(result > 0){
				msg.setSuccess(true);
				if("0".equals(roleModel.getState())){
					msg.setMsg("操作成功!");
				}else if("1".equals(roleModel.getState())){
					msg.setMsg("操作成功!");
				}
			}
		} catch (Exception e) {
			msg.setSuccess(false);
		}
		return msg;
	}
	/**
	 * 为角色设置权限
	 * @param request
	 * @param roleId
	 * @return
	 */
	@RequestMapping(value = "to_set_menu")
	public String toSetMenu(HttpServletRequest request, Long roleId){
		
		List<Menu> menuList = roleService.findMenuList();
		Map<Long, Long> menuMap = roleService.findMenuMap(roleId);
		
		request.setAttribute("roleId", roleId);
		request.setAttribute("menuMap", menuMap);
		request.setAttribute("menuList", menuList);
		
		return "func/role/set_menu";
	}
	/**
	 * 删除角色
	 * @param menuModel
	 * @return
	 */
	@RequestMapping("do_delete_role")
	@ResponseBody
	public JsonMsg doDeleteMenu(RoleModel roleModel){
		JsonMsg msg = new JsonMsg("操作失败!");
		try{
			int result = roleService.delete(roleModel);
			if(result > 0){
				msg.setSuccess(true);
				msg.setMsg("操作成功!");
			}
		}catch(Exception e){
			msg.setSuccess(false);
			msg.setMsg("操作失败!");
			log.error("操作失败!", e);
		}
		return msg;
	}
	/**
	 * 保存权限
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "do_set_menu")
	@ResponseBody
	public JsonMsg doSetMenu(HttpServletRequest request){
		String roleId = request.getParameter("roleId");
		String[] menuIds = request.getParameterValues("menuIds");
		JsonMsg msg = new JsonMsg();
		msg.setMsg("操作失败!");
		msg.setSuccess(false);
		try{
			boolean result = roleService.setMenu(roleId, menuIds);
			if(result){
				msg.setMsg("操作成功!");
				msg.setSuccess(true);
			}
		}catch(Exception e){
			msg.setMsg("操作失败!");
			msg.setSuccess(false);
		}
		
		return msg;
	}


}
