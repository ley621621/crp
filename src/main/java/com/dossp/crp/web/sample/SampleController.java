/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: SampleController.java 
 *
 * @Date:  2016年12月30日  下午4:12:06
 *
 * @Package com.dossp.crp.web.sample
 */


package com.dossp.crp.web.sample;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dossp.crp.sample.model.SampleModel;
import com.dossp.crp.sample.service.SampleService;
import com.dossp.crp.sample.vo.SampleVo;
import com.github.pagehelper.PageInfo;

/**
 * @author yufenghui
 * </p>
 * 日期：2016年12月30日 下午4:12:06
 * </p>
 * 描述：
 *
 */
@Controller
@RequestMapping(value = "/sample")
public class SampleController {
	
	@Autowired
	private SampleService sampleService;
	
	/**
	 * 
	 * @param request
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "to_list")
	public String to_list(HttpServletRequest request, SampleVo vo) {
		
		PageInfo<SampleModel> pageInfo = sampleService.findSamplePage(vo);
		
		request.setAttribute("pageInfo", pageInfo);
		
		return "/sample/to_list";
	}
	
}
