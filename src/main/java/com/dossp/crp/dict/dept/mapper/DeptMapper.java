/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: DeptMapper.java 
 *
 * @Date:  2016年10月21日  下午12:22:04
 *
 * @Package com.dossp.pms.dict.dept.mapper
 */


package com.dossp.crp.dict.dept.mapper;

import java.util.List;

import com.dossp.crp.common.mybatis.MyBaseMapper;
import com.dossp.crp.dict.dept.model.DeptModel;
import com.dossp.crp.dict.dept.vo.DeptVo;

/**
 * @author yufenghui
 * </p>
 * 日期：2016年10月21日 下午12:22:04
 * </p>
 * 描述：
 *
 */

public interface DeptMapper extends MyBaseMapper<DeptModel> {
	
	/**
	 * 查询部门列表
	 * @param deptVo
	 * @return
	 */
	public List<DeptModel> findDeptPage(DeptVo deptVo);
	
	public DeptModel findDept(DeptVo deptVo);
	
	public List<DeptModel> findDeptList();
	
}
