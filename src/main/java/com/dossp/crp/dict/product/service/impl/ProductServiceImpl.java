/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: ProductServiceImpl.java 
 *
 * @Date:  2016年11月8日  下午1:58:36
 *
 * @Package com.dossp.pms.dict.product.service.impl
 */


package com.dossp.crp.dict.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dossp.crp.common.service.impl.BaseServiceImpl;
import com.dossp.crp.dict.product.mapper.ProductMapper;
import com.dossp.crp.dict.product.model.ProductModel;
import com.dossp.crp.dict.product.service.ProductService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * @author yufenghui
 * </p>
 * 日期：2016年11月8日 下午1:58:36
 * </p>
 * 描述：
 *
 */
@Service
public class ProductServiceImpl extends BaseServiceImpl<ProductModel, Long> implements ProductService {

	@Autowired
	private ProductMapper productMapper;
	
	/** 
	 * @param type
	 * @return 
	 */
	@Override
	public List<ProductModel> findProductList(String type) {
		Example example = new Example(ProductModel.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("type", type);
		return productMapper.selectByExample(example);
	}

}
