/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: CorpService.java 
 *
 * @Date:  2016年11月8日  下午1:54:24
 *
 * @Package com.dossp.pms.dict.corp.service
 */


package com.dossp.crp.dict.corp.service;

import java.util.List;

import com.dossp.crp.common.service.BaseService;
import com.dossp.crp.dict.corp.model.CorpModel;

/**
 * @author yufenghui
 * </p>
 * 日期：2016年11月8日 下午1:54:24
 * </p>
 * 描述：
 *
 */

public interface CorpService extends BaseService<CorpModel, Long> {

	public List<CorpModel> findCorpList();
	
	/**
	 * 查询未填报的中心列表
	 * @return
	 */
	public List<CorpModel> findCorpNaList(String date);
}
