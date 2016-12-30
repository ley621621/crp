/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: SampleMapper.java 
 *
 * @Date:  2016年12月30日  下午3:35:15
 *
 * @Package com.dossp.crp.sample.mapper
 */


package com.dossp.crp.sample.mapper;

import java.util.List;

import com.dossp.crp.common.mybatis.MyBaseMapper;
import com.dossp.crp.sample.model.SampleModel;
import com.dossp.crp.sample.vo.SampleVo;

/**
 * @author yufenghui
 * </p>
 * 日期：2016年12月30日 下午3:35:15
 * </p>
 * 描述：
 *
 */

public interface SampleMapper extends MyBaseMapper<SampleModel> {

	/** 
	 * @param vo
	 * @return 
	 */
	List<SampleModel> findSampleList(SampleVo vo);

}
