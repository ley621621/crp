/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: SampleModel.java 
 *
 * @Date:  2016年12月30日  下午3:32:54
 *
 * @Package com.dossp.crp.sample.model
 */


package com.dossp.crp.sample.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dossp.crp.common.model.BaseModel;

/**
 * @author yufenghui
 * </p>
 * 日期：2016年12月30日 下午3:32:54
 * </p>
 * 描述：
 *
 */
@Table(name = "sample")
public class SampleModel extends BaseModel {
	

	 /** 
	 * 
	 * @Fields serialVersionUID
	 */ 
	private static final long serialVersionUID = 6187310300752950316L;
	
	/**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "id")
    private Long id;
    
    private String name;
    
    private Integer age;
    
    @Column(name = "create_time")
    private Date createTime;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
    
}
