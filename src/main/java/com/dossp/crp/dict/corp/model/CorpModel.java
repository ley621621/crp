/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: CorpModel.java 
 *
 * @Date:  2016年11月8日  下午1:53:30
 *
 * @Package com.dossp.pms.dict.corp
 */


package com.dossp.crp.dict.corp.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dossp.crp.common.model.BaseModel;

/**
 * @author yufenghui
 * </p>
 * 日期：2016年11月8日 下午1:53:30
 * </p>
 * 描述：
 *
 */
@Table(name = "dict_corp")
public class CorpModel extends BaseModel {

	/** 
	 * 
	 * @Fields serialVersionUID
	 */ 
	private static final long serialVersionUID = 7304408523347641836L;

	@Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    private String code;

    private String name;

    @Column(name = "parent_id")
    private Long parentId;

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

    /**
     * @return parent_id
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
    
}
