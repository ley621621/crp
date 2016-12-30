/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: SampleService.java 
 *
 * @Date:  2016年12月30日  下午3:36:10
 *
 * @Package com.dossp.crp.sample.service
 */


package com.dossp.crp.sample.service;

import com.dossp.crp.common.service.BaseService;
import com.dossp.crp.sample.model.SampleModel;
import com.dossp.crp.sample.vo.SampleVo;
import com.github.pagehelper.PageInfo;

/**
 * @author yufenghui
 * </p>
 * 日期：2016年12月30日 下午3:36:10
 * </p>
 * 描述：
 *
 */

public interface SampleService extends BaseService<SampleModel, Long> {
	
	public PageInfo<SampleModel> findSamplePage(SampleVo vo);

}
