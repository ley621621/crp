/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: SystemController.java 
 *
 * @Date:  2016年10月24日  下午12:57:09
 *
 * @Package com.dossp.pms.web.system
 */


package com.dossp.crp.web.system;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dossp.crp.common.model.JsonMsg;
import com.dossp.crp.common.util.DateUtil;
import com.dossp.crp.common.util.SpringEncryptUtil;
import com.dossp.crp.func.menu.model.MenuModel;
import com.dossp.crp.func.menu.service.MenuService;
import com.dossp.crp.func.user.model.UserModel;
import com.dossp.crp.func.user.service.UserService;
import com.dossp.crp.web.util.SessionUtil;
import com.dossp.crp.web.util.UserSessionModel;

/**
 * @author yufenghui
 * </p>
 * 日期：2016年10月24日 下午12:57:09
 * </p>
 * 描述：
 *
 */
@Controller
@RequestMapping(value = "/")
public class SystemController {
	
	private static final Logger log = LoggerFactory.getLogger(SystemController.class);
	@Autowired
	private UserService userService;
	@Autowired
	private MenuService menuService;
	
	/**
	 * 跳转到登录界面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/")
	public String to_login() {
		
		return "/login";
	}
	
	/**
	 * 跳转到登陆后主页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "main")
	public String main(HttpServletRequest request) {
		String date = DateUtil.formateLocaleDate("yyyy-MM-dd");
		HttpSession session = request.getSession();
		if(StringUtils.isBlank(date)){
			date = (String) session.getAttribute("tradeTime");
		}else{
			session.setAttribute("tradeTime", date);
			session.removeAttribute("createTime");
		}
		//通过userId获取登陆角色
		UserSessionModel userSession = SessionUtil.getUser(request);
		Long userId = userSession.getUserId();
		//通过userId获取权限
		List<MenuModel> menuList = userService.findUserMenuList(userId);
		//如果登陆用户包含报表权限，则显示弹出框
		boolean isShow = false;
		for (int i = 0; i < menuList.size(); i++) {
			MenuModel menu = menuList.get(i);
			if(menu.getId() == 83){
				isShow = true;
				break;
			}
		}
		request.setAttribute("date", date);
		request.setAttribute("isShow", isShow);
		
		return "/main";
	}
	
	/**
	 * 跳转到中央界面
	 * 
	 * @return
	 */
	@RequestMapping(value = "center")
	public String center() {
		
		return "/center";
	}
	
	/**
	 * 验证登录
	 * 
	 * @param account
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "check_login")
	public String check_login(HttpServletRequest request, String account, String password) {
		boolean flag = false;
		UserModel model = new UserModel();
		model.setAccount(account);
		UserModel ret = userService.findUserByAccount(account);
		if(ret != null && ret.getId() != null) {
			if(SpringEncryptUtil.match(password, ret.getPassword())) {
				flag = true;
				// 将用户放入session中去
				UserSessionModel user = new UserSessionModel();
				user.setUserId(ret.getId());
				user.setUserNa(ret.getName());
				user.setCorpId(ret.getCorpId());
				user.setAccount(ret.getAccount());
				user.setCorpNa(ret.getCorpName());
				// 获取用户菜单
				List<MenuModel> menus = userService.findUserMenuList(ret.getId());
				if("admin".equals(ret.getAccount())) {
					MenuModel m = new MenuModel();
					m.setState("0");
					menus = menuService.selectList(m);
					
				}
				user.setMenus(menus);
				
				SessionUtil.saveUser(request, user);
			}
		}
		
		if(flag) {
			// 获取用户菜单及属性
			return "redirect:/main";
		} else {
			request.setAttribute("login_message", "请重新登录");
			return "/login";
		}
		
	}
	
	/**
	 * 退出登录
	 * 
	 * @return
	 */
	@RequestMapping(value = "to_change_password")
	public String to_change_password() {
		return "/change_password";
	}
	
	/**
	 * 修改密码
	 */
	@RequestMapping(value = "change_password")
	@ResponseBody
	public JsonMsg change_password(HttpServletRequest request, String password) {
		JsonMsg msg = new JsonMsg("操作失败!");
		try {
			UserSessionModel user = SessionUtil.getUser(request);
			UserModel model = new UserModel();
			model.setId(user.getUserId());
			model.setPassword(SpringEncryptUtil.encrypt(password));
			int ret = userService.update(model);
			if(ret > 0) {
				msg.setSuccess(true);
				msg.setMsg("操作成功!");
			}
		} catch (Exception e) {
			msg.setSuccess(false);
			msg.setMsg("操作失败!");
			log.error("操作失败!", e);
		}
		return msg;
	}
	
	/**
	 * 检查密码是否正确
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "check_password")
	@ResponseBody
	public JsonMsg check_password(HttpServletRequest request, String password) {
		JsonMsg msg = new JsonMsg("密码错误。");
		try {
			UserSessionModel user = SessionUtil.getUser(request);
			UserModel model = new UserModel();
			model.setId(user.getUserId());
			
			UserModel ret = userService.findUserByAccount(user.getAccount());
			boolean flag = SpringEncryptUtil.match(password, ret.getPassword());
			if(flag) {
				msg.setSuccess(true);
				msg.setMsg("密码正确。");
			}
		} catch (Exception e) {
			msg.setSuccess(false);
			msg.setMsg("密码错误。");
			log.error("密码错误。", e);
		}
		return msg;
	}
	
	/**
	 * 退出登录
	 * 
	 * @return
	 */
	@RequestMapping(value = "logout")
	public String logout(HttpServletRequest request) {
		SessionUtil.removeUser(request);
		return "redirect:/";
	}
	
	@RequestMapping("/do_isEquals")
	@ResponseBody
	public JsonMsg doIsEquals(HttpServletRequest request){
		JsonMsg msg = new JsonMsg();
		msg.setSuccess(false);
		
		UserSessionModel user = SessionUtil.getUser(request);
		Long userId = user.getUserId();
		
		//判断登录用户密码是否为初始密码
		UserModel item = userService.findUser(userId);
		String password = item.getPassword();
		//判断登录用户密码是否为初始密码
		if(SpringEncryptUtil.match("000000", password)){
			msg.setSuccess(true);
		}
		
		return msg;
	}
	
	/**
	 * 错误页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "error")
	public void error(HttpServletRequest request, HttpServletResponse response) {
		try {
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<script>");
			out.println("window.open ('" + request.getContextPath() + "/', '_top')");
			out.println("</script>");
			out.println("</html>");
		} catch (Exception e) {
			// 这里出错不能抛出，否则死循环
		}
	}

}
