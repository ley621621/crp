/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: SampleServiceImpl.java 
 *
 * @Date:  2016年12月30日  下午3:37:16
 *
 * @Package com.dossp.crp.sample.service.impl
 */


package com.dossp.crp.sample.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dossp.crp.common.service.impl.BaseServiceImpl;
import com.dossp.crp.sample.mapper.SampleMapper;
import com.dossp.crp.sample.model.SampleModel;
import com.dossp.crp.sample.service.SampleService;
import com.dossp.crp.sample.vo.SampleVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author yufenghui
 * </p>
 * 日期：2016年12月30日 下午3:37:16
 * </p>
 * 描述：
 *
 */
@Service
public class SampleServiceImpl extends BaseServiceImpl<SampleModel, Long> implements SampleService {
	
	@Autowired
	private SampleMapper sampleMapper;

	/** 
	 * @return 
	 */
	@Override
	public PageInfo<SampleModel> findSamplePage(SampleVo vo) {
		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		List<SampleModel> list = sampleMapper.findSampleList(vo);
		return new PageInfo<SampleModel>(list);
	}

}
