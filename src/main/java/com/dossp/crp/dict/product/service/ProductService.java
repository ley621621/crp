/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: ProductService.java 
 *
 * @Date:  2016年11月8日  下午1:58:11
 *
 * @Package com.dossp.pms.dict.product.service
 */


package com.dossp.crp.dict.product.service;

import java.util.List;

import com.dossp.crp.common.service.BaseService;
import com.dossp.crp.dict.product.model.ProductModel;

/**
 * @author yufenghui
 * </p>
 * 日期：2016年11月8日 下午1:58:11
 * </p>
 * 描述：
 *
 */

public interface ProductService extends BaseService<ProductModel, Long> {

	/** 
	 * @return 
	 */
	public List<ProductModel> findProductList(String type);

}
