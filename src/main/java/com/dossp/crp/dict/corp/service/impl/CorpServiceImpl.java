/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: CorpServiceImpl.java 
 *
 * @Date:  2016年11月8日  下午1:54:49
 *
 * @Package com.dossp.pms.dict.corp.service.impl
 */


package com.dossp.crp.dict.corp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dossp.crp.common.service.impl.BaseServiceImpl;
import com.dossp.crp.dict.corp.mapper.CorpMapper;
import com.dossp.crp.dict.corp.model.CorpModel;
import com.dossp.crp.dict.corp.service.CorpService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * @author yufenghui
 * </p>
 * 日期：2016年11月8日 下午1:54:49
 * </p>
 * 描述：
 *
 */
@Service
public class CorpServiceImpl extends BaseServiceImpl<CorpModel, Long> implements CorpService {

	@Autowired
	private CorpMapper corpMapper;
	/** 
	 * @return 
	 */
	@Override
	public List<CorpModel> findCorpList() {
		Example example = new Example(CorpModel.class);
		Criteria criteria = example.createCriteria();
		criteria.andNotEqualTo("parentId", "0");
		example.orderBy("code").asc();
		return corpMapper.selectByExample(example);
	}
	
	/**
	 * 查询未填报的中心列表
	 * @return
	 */
	@Override
	public List<CorpModel> findCorpNaList(String date) {
		List<CorpModel> corpList = corpMapper.findCorpNaList(date);
		return corpList;
	}

}
