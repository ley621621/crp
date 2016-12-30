/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: BaseServiceImpl.java 
 *
 * @Date:  2016年8月26日  下午4:21:28
 *
 * @Package com.dossp.mcprc.cnm.common.service.impl
 */

package com.dossp.crp.common.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.dossp.crp.common.mybatis.MyBaseMapper;
import com.dossp.crp.common.service.BaseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;

/**
 * @author yufenghui
 *         </p>
 *         日期：2016年8月26日 下午4:21:28
 *         </p>
 *         描述：公共service实现类
 *
 */

public abstract class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID> {

	@Autowired
	protected MyBaseMapper<T> mapper;

	@Override
	public int insert(T record) {
		Preconditions.checkNotNull(record, "实体不能为空。");
		return mapper.insertSelective(record);
	}

	@Override
	public int delete(T record) {
		Preconditions.checkNotNull(record, "实体不能为空。");
		return mapper.delete(record);
	}

	@Override
	public int deleteById(ID id) {
		Preconditions.checkNotNull(id, "id不能为空。");
		return mapper.deleteByPrimaryKey(id);
	}
	
	@Override
	public int deleteByIds(String ids) {
		Preconditions.checkArgument(StringUtils.isNoneBlank(ids), "ids不能为空。");
		return mapper.deleteByIds(ids);
	}

	@Override
	public int update(T record) {
		Preconditions.checkNotNull(record, "实体不能为空。");
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public T selectOne(T record) {
		Preconditions.checkNotNull(record, "实体不能为空。");
		return mapper.selectOne(record);
	}

	@Override
	public T selectById(ID id) {
		Preconditions.checkNotNull(id, "id不能为空。");
		return mapper.selectByPrimaryKey(id);
	}
	
	@Override
	public List<T> selectByIds(String ids) {
		Preconditions.checkArgument(StringUtils.isNoneBlank(ids), "ids不能为空。");
		return mapper.selectByIds(ids);
	}

	@Override
	public List<T> selectList() {
		return mapper.selectAll();
	}
	
	/**
	 * 查询全部结果，select(null)方法能达到同样的效果，查询条件使用等号
	 * @return
	 */
	@Override
	public List<T> selectList(T record) {
		Preconditions.checkNotNull(record, "实体不能为空。");
		return mapper.selectList(record);
	}

	@Override
	public PageInfo<T> listPage(int pageNum, int pageSize) {
		Preconditions.checkArgument(pageNum > 0, "页码必须大于0。");
		Preconditions.checkArgument(pageSize > 0, "页记录数必须大于0。");
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<T>(mapper.selectAll());
	}
	
	@Override
	public PageInfo<T> listPage(T t, int pageNum, int pageSize) {
		Preconditions.checkArgument(pageNum > 0, "页码必须大于0。");
		Preconditions.checkArgument(pageSize > 0, "页记录数必须大于0。");
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<T>(mapper.selectList(t));
	}

}
