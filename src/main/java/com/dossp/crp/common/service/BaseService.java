/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: BaseService.java 
 *
 * @Date:  2016年8月26日  下午4:20:07
 *
 * @Package com.dossp.mcprc.cnm.common.service
 */

package com.dossp.crp.common.service;

import java.io.Serializable;
import java.util.List;

import com.github.pagehelper.PageInfo;

/**
 * @author yufenghui
 *         </p>
 *         日期：2016年8月26日 下午4:20:07
 *         </p>
 *         描述：
 *
 */

public interface BaseService<T, ID extends Serializable> {

	/**
	 * 保存一个实体，null的属性不会保存，会使用数据库默认值
	 * @param record
	 * @return
	 */
	public int insert(T record);
	
	/**
	 * 根据主键更新属性不为null的值
	 * @param record
	 * @return
	 */
	public int update(T record);

	/**
	 * 根据实体属性作为条件进行删除，查询条件使用等号
	 * @param record
	 * @return
	 */
	public int delete(T record);

	/**
	 * 根据主键字段进行删除，方法参数必须包含完整的主键属性
	 * @param id
	 * @return
	 */
	public int deleteById(ID id);
	
	/**
	 * 根据主键字符串进行删除，类中只有存在一个带有@Id注解的字段
	 * </p>
	 * 通过操作ids字符串进行操作，ids 如 "1,2,3" 这种形式的字符串。
	 * </p>
	 * 这个方法要求实体类中有且只有一个带有@Id注解的字段，否则会抛出异常。
	 * @param ids
	 * @return
	 */
	public int deleteByIds(String ids);

	/**
	 * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
	 * @param record
	 * @return
	 */
	public T selectOne(T record);

	/**
	 * 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
	 * @param id
	 * @return
	 */
	public T selectById(ID id);
	
	/**
	 * 根据主键字符串进行查询，类中只有存在一个带有@Id注解的字段。
	 * </p>
	 * 通过操作ids字符串进行操作，ids 如 "1,2,3" 这种形式的字符串。
	 * </p>
	 * 这个方法要求实体类中有且只有一个带有@Id注解的字段，否则会抛出异常。
	 * @param ids
	 * @return
	 */
	public List<T> selectByIds(String ids);

	/**
	 * 查询全部结果，select(null)方法能达到同样的效果
	 * @return
	 */
	public List<T> selectList();
	
	/**
	 * 查询全部结果，select(null)方法能达到同样的效果，查询条件使用等号
	 * @return
	 */
	public List<T> selectList(T record);

	/**
	 * 分页查询全部结果
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageInfo<T> listPage(int pageNum, int pageSize);
	
	/**
	 * 根据条件分页查询全部结果，查询条件使用等号
	 * @param t
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageInfo<T> listPage(T t, int pageNum, int pageSize);

}
