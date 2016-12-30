/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: SampleServiceTest.java 
 *
 * @Date:  2016年12月30日  下午3:44:09
 *
 * @Package com.dossp.crp.sample
 */


package com.dossp.crp.sample;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dossp.crp.common.BaseTest;
import com.dossp.crp.sample.model.SampleModel;
import com.dossp.crp.sample.service.SampleService;
import com.dossp.crp.sample.vo.SampleVo;
import com.github.pagehelper.PageInfo;

/**
 * @author yufenghui
 * </p>
 * 日期：2016年12月30日 下午3:44:09
 * </p>
 * 描述：
 *
 */

public class SampleServiceTest extends BaseTest {
	
	@Autowired
	private SampleService sampleService;
	
	
	@Test
	public void testFindSamplePage() {
		
		SampleVo vo = new SampleVo();
		
		PageInfo<SampleModel> pageInfo = sampleService.findSamplePage(vo);
		
		System.out.println(pageInfo.getList().size());
	}
	

}
