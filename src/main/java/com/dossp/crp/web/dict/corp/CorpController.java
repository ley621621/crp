/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: CorpController.java 
 *
 * @Date:  2016年11月11日  下午3:31:29
 *
 * @Package com.dossp.pms.web.dict.corp
 */


package com.dossp.crp.web.dict.corp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dossp.crp.dict.corp.model.CorpModel;
import com.dossp.crp.dict.corp.service.CorpService;

/**
 * @author liuzijian
 * </p>
 * 日期：2016年11月11日 下午3:31:29
 * </p>
 * 描述：
 *
 */
@Controller
@RequestMapping(value = "/dict/corp")
public class CorpController {

	@Autowired
	private CorpService corpService;
	/**
	 * 跳转到列表页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "to_corp_list")
	public String toCorpList(HttpServletRequest request){
		
		List<CorpModel> items = corpService.selectList();
		request.setAttribute("items", items);
		
		return "/dict/corp/corp_list";
	}
}
