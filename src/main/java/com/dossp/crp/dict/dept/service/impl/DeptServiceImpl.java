/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: DeptServiceImpl.java 
 *
 * @Date:  2016年10月21日  下午12:22:47
 *
 * @Package com.dossp.pms.dict.dept.service.impl
 */


package com.dossp.crp.dict.dept.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dossp.crp.common.service.impl.BaseServiceImpl;
import com.dossp.crp.dict.dept.mapper.DeptMapper;
import com.dossp.crp.dict.dept.model.DeptModel;
import com.dossp.crp.dict.dept.service.DeptService;
import com.dossp.crp.dict.dept.vo.DeptVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author yufenghui
 * </p>
 * 日期：2016年10月21日 下午12:22:47
 * </p>
 * 描述：
 *
 */
@Service
public class DeptServiceImpl extends BaseServiceImpl<DeptModel, Long> implements DeptService {

	@Autowired
	private DeptMapper deptMapper;
	
	/** 
	 * 查询部门列表
	 * @param deptVo
	 * @return 
	 */
	public PageInfo<DeptModel> findDeptPage(DeptVo deptVo) {
		PageHelper.startPage(deptVo.getPageNum(), deptVo.getPageSize());
		List<DeptModel> list = deptMapper.findDeptPage(deptVo);
		return new PageInfo<DeptModel>(list);
	}
	/** 
	 * @return 
	 */
	
	
	@Override
	public List<DeptModel> findDeptList() {
		List<DeptModel> deptList = deptMapper.findDeptList();
		return deptList;
	}
}
