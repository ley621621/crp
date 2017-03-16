/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: UserController.java 
 *
 * @Date:  2016年10月21日  下午7:07:27
 *
 * @Package com.dossp.pms.web.func.user
 */

package com.dossp.crp.web.func.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dossp.crp.common.model.JsonMsg;
import com.dossp.crp.common.util.SpringEncryptUtil;
import com.dossp.crp.dict.corp.model.CorpModel;
import com.dossp.crp.dict.corp.service.CorpService;
import com.dossp.crp.func.role.model.RoleModel;
import com.dossp.crp.func.role.service.RoleService;
import com.dossp.crp.func.user.model.UserModel;
import com.dossp.crp.func.user.model.UserRoleModel;
import com.dossp.crp.func.user.service.UserRoleService;
import com.dossp.crp.func.user.service.UserService;
import com.dossp.crp.func.user.vo.UserVo;
import com.github.pagehelper.PageInfo;

/**
 * @author shaoyingjie
 *         </p>
 *         日期：2016年10月21日 下午7:07:27
 *         </p>
 *         描述：
 *
 */
@Controller
@RequestMapping("/func/user")
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Value("${ROOT_CORP_ID}")
	private Long ROOT_CORP_ID;
	@Autowired
	private UserService userService;
	@Autowired
	private CorpService corpService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserRoleService userRoleService;

	/**
	 * 跳转新增页面
	 * @param request
	 * @return
	 */
	@RequestMapping("to_add_user")
	public String toSaveUser(HttpServletRequest request) {
		
		List<CorpModel> corpList = corpService.selectList();
		List<RoleModel> roleList = roleService.findRoleList();
		
		request.setAttribute("corpList", corpList);
		request.setAttribute("roleList", roleList);
		
		return "func/user/add_user";
	}
	
	/**
	 * 新增用户
	 * @param userModel
	 * @param roleList
	 * @return
	 */
	@RequestMapping("do_add_user")
	@ResponseBody
	public JsonMsg doAddUser(UserModel userModel, String[] roleList) {
		JsonMsg ret = new JsonMsg("操作失败!");
		try {
			userModel.setPassword(SpringEncryptUtil.encrypt("000000"));
			userModel.setState("0");
			int flag = userService.saveUser(userModel, roleList);
			if (flag > 0) {
				ret.setSuccess(true);
				ret.setMsg("操作成功!");
			}
		} catch (Exception e) {
			ret.setSuccess(false);
			ret.setMsg("操作失败!");
			log.error("操作失败!", e);
		}
		return ret;
	}
	/**
	 * 跳转列表页面
	 * @param userVo
	 * @param request
	 * @return
	 */
	@RequestMapping("to_user_list")
	public String toUserList(UserVo userVo, HttpServletRequest request) {
		
		List<RoleModel> roleList = roleService.findRoleList();
		List<CorpModel> corpList = corpService.findCorpList();
		
		PageInfo<UserModel> pageInfo = userService.findPageInfo(userVo);

		request.setAttribute("vo", userVo);
		request.setAttribute("corpList", corpList);
		request.setAttribute("roleList", roleList);
		request.setAttribute("pageInfo", pageInfo);
		
		return "func/user/user_list";
	}
	
	/**
	 * 跳转编辑页面
	 * @param request
	 * @param userId
	 * @return
	 */
	@RequestMapping("to_update_user")
	public String toUpdateUser(HttpServletRequest request, Long userId) {
		
		UserModel model = userService.findUser(userId);
		List<CorpModel> corpList = corpService.selectList();
		List<RoleModel> roleList = roleService.findUserRoleNot(userId);
		List<UserRoleModel> userRole = userRoleService.findUserRole(userId);
		
		request.setAttribute("model", model);
		request.setAttribute("corpList", corpList);
		request.setAttribute("roleList", roleList);
		request.setAttribute("userRole", userRole);
		
		return "func/user/update_user";
	}

	/**
	 * 编辑人员
	 * @param userModel
	 * @param roleList
	 * @return
	 */
	@RequestMapping("do_update_user")
	@ResponseBody
	public JsonMsg doUpdateUser(UserModel user, String[] roleList) {
		JsonMsg ret = new JsonMsg("操作失败!");
		try {
			int flag = userService.update(user);
			flag = userService.updateUser(user.getId(), roleList);
			if (flag > 0) {
				ret.setSuccess(true);
				ret.setMsg("操作成功!");
			}
		} catch (Exception e) {
			ret.setSuccess(false);
			ret.setMsg("操作失败!");
			log.error("操作失败!", e);
		}
		return ret;
	}
	/**
	 * 设置角色
	 * @param request
	 * @param userId
	 * @return
	 */
	@RequestMapping("to_set_role")
	public String toSetRole(HttpServletRequest request,Long userId){
		
		UserModel model = userService.selectById(userId);
		List<RoleModel> roleList = roleService.findUserRoleNot(userId);
		List<UserRoleModel> userRole = userRoleService.findUserRole(userId);
		
		request.setAttribute("model", model);
		request.setAttribute("userRole",userRole);
		request.setAttribute("roleList", roleList);
		
		return "func/user/set_role";
	}
	
	/**
	 * 人员启用禁用
	 * @param userModel
	 * @return
	 */
	@RequestMapping("update_state")
	@ResponseBody
	public JsonMsg updateState(UserModel userModel){
		JsonMsg msg = new JsonMsg("");
		try {
			int result = userService.update(userModel);
			if(result > 0){
				msg.setSuccess(true);
				if("0".equals(userModel.getState())){
					msg.setMsg("操作成功!");
				}else if("1".equals(userModel.getState())){
					msg.setMsg("操作成功!");
				}
			}
		} catch (Exception e) {
			msg.setSuccess(false);
		}
		return msg;
	}
	
	
	/**
	 * 重置密码
	 * @param userModel
	 * @return
	 */
	@RequestMapping("resetPwd")
	@ResponseBody
	public JsonMsg resetPwd(UserModel userModel) {
		JsonMsg ret = new JsonMsg("操作失败!");
		try {
			userModel.setPassword(SpringEncryptUtil.encrypt("000000"));
			int flag = userService.resetPwd(userModel);
			if (flag > 0) {
				ret.setSuccess(true);
				ret.setMsg("操作成功!");
			}
		} catch (Exception e) {
			ret.setSuccess(false);
			ret.setMsg("操作失败!");
			log.error("操作失败!", e);
		}
		return ret;
	}
	
}
