/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: CorpMapper.java 
 *
 * @Date:  2016年11月8日  下午1:54:09
 *
 * @Package com.dossp.pms.dict.corp.mapper
 */


package com.dossp.crp.dict.corp.mapper;

import java.util.List;

import com.dossp.crp.common.mybatis.MyBaseMapper;
import com.dossp.crp.dict.corp.model.CorpModel;

/**
 * @author yufenghui
 * </p>
 * 日期：2016年11月8日 下午1:54:09
 * </p>
 * 描述：
 *
 */

public interface CorpMapper extends MyBaseMapper<CorpModel> {
	
	/**
	 * 查询未填报的中心列表
	 * @return
	 */
	public List<CorpModel> findCorpNaList(String date);


}
