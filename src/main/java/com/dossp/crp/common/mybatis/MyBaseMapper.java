/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: MyBaseMapper.java 
 *
 * @Date:  2016年8月26日  下午4:19:16
 *
 * @Package com.dossp.mcprc.cnm.common.mybatis.mapper
 */

package com.dossp.crp.common.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;

import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author yufenghui
 *         </p>
 *         日期：2016年8月26日 下午4:19:16
 *         </p>
 *         描述：
 *
 */

public interface MyBaseMapper<T> extends Mapper<T>, IdsMapper<T> {
	
	/**
	 * 根据条件查询全部结果
	 * 
	 * @param record
	 * @return
	 */
	@SelectProvider(type = MySelectProvider.class, method = "dynamicSQL")
	List<T> selectList(T record);

}
