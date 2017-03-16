/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: DeptService.java 
 *
 * @Date:  2016年10月21日  下午12:22:23
 *
 * @Package com.dossp.pms.dict.dept.service
 */


package com.dossp.crp.dict.dept.service;

import java.util.List;

import com.dossp.crp.common.service.BaseService;
import com.dossp.crp.dict.dept.model.DeptModel;
import com.dossp.crp.dict.dept.vo.DeptVo;
import com.github.pagehelper.PageInfo;

/**
 * @author yufenghui
 * </p>
 * 日期：2016年10月21日 下午12:22:23
 * </p>
 * 描述：
 *
 */

public interface DeptService extends BaseService<DeptModel, Long> {
	
	/** 
	 * 查询部门列表
	 * @param deptVo
	 * @return 
	 */
	public PageInfo<DeptModel> findDeptPage(DeptVo deptVo);
	
	public List<DeptModel> findDeptList();

}
