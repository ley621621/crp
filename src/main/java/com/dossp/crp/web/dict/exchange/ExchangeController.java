/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: ExchangeController.java 
 *
 * @Date:  2016年11月21日  上午8:54:41
 *
 * @Package com.dossp.pms.web.dict.exchange
 */


package com.dossp.crp.web.dict.exchange;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dossp.crp.dict.exchange.model.ExchangeModel;
import com.dossp.crp.dict.exchange.service.ExchangeService;

/**
 * @author liuzijian
 * </p>
 * 日期：2016年11月21日 上午8:54:41
 * </p>
 * 描述：
 *
 */
@Controller
@RequestMapping(value = "dict/exchange")
public class ExchangeController {
	
	@Autowired
	private ExchangeService exchangeService;
	
	@RequestMapping(value = "to_exchange_list")
	public String toExchangeList(HttpServletRequest request){
		
		List<ExchangeModel> items = exchangeService.selectList();
		
		request.setAttribute("items", items);
		
		return "/dict/exchange/exchange_list";
		
	}
}
