/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: ExchangeModel.java 
 *
 * @Date:  2016年11月8日  下午1:55:31
 *
 * @Package com.dossp.pms.dict.exchange.model
 */


package com.dossp.crp.dict.exchange.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dossp.crp.common.model.BaseModel;

/**
 * @author yufenghui
 * </p>
 * 日期：2016年11月8日 下午1:55:31
 * </p>
 * 描述：
 *
 */
@Table(name = "dict_exchange")
public class ExchangeModel extends BaseModel {

	/** 
	 * 
	 * @Fields serialVersionUID
	 */ 
	private static final long serialVersionUID = -5297527470093374709L;

	@Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    private String code;

    private String name;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    
}
