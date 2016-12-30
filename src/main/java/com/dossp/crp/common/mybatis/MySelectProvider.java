/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: MySelectProvider.java 
 *
 * @Date:  2016年8月26日  下午4:16:46
 *
 * @Package com.dossp.mcprc.cnm.common.mybatis.provider
 */

package com.dossp.crp.common.mybatis;

import org.apache.ibatis.mapping.MappedStatement;

import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.SqlHelper;
import tk.mybatis.mapper.provider.base.BaseSelectProvider;

/**
 * @author yufenghui
 *         </p>
 *         日期：2016年8月26日 下午4:16:46
 *         </p>
 *         描述：
 *
 */

public class MySelectProvider extends BaseSelectProvider {

	/**
	 * @param mapperClass
	 * @param mapperHelper
	 */
	public MySelectProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
		super(mapperClass, mapperHelper);
	}

	/**
	 * 根据条件查询全部结果
	 *
	 * @param ms
	 * @return
	 */
	public String selectList(MappedStatement ms) {
		final Class<?> entityClass = getEntityClass(ms);
		// 修改返回值类型为实体类型
		setResultType(ms, entityClass);
		StringBuilder sql = new StringBuilder();
		sql.append(SqlHelper.selectAllColumns(entityClass));
		sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
		sql.append(SqlHelper.whereAllIfColumns(entityClass, isNotEmpty()));
		sql.append(SqlHelper.orderByDefault(entityClass));
		return sql.toString();
	}

}
