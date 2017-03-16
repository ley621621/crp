/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: ProductController.java 
 *
 * @Date:  2016年11月21日  上午9:24:24
 *
 * @Package com.dossp.pms.web.dict.product
 */


package com.dossp.crp.web.dict.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dossp.crp.dict.product.model.ProductModel;
import com.dossp.crp.dict.product.service.ProductService;

/**
 * @author liuzijian
 * </p>
 * 日期：2016年11月21日 上午9:24:24
 * </p>
 * 描述：
 *
 */
@Controller
@RequestMapping(value = "dict/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "to_product_list")
	public String toProductList(HttpServletRequest request, String type){
		
		List<ProductModel> items = productService.findProductList(type);
		
		request.setAttribute("type", type);
		request.setAttribute("items", items);
		
		return "/dict/product/product_list";
	}
}
