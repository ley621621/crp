/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: CorpModel.java 
 *
 * @Date:  2016年11月8日  下午1:53:30
 *
 * @Package com.dossp.pms.dict.corp
 */

package com.dossp.crp.dict.nearst.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dossp.crp.common.model.BaseModel;

/**
 * @author yufenghui
 *         </p>
 *         日期：2016年11月8日 下午1:53:30
 *         </p>
 *         描述：
 * 
 */
@Table(name = "dict_nearst")
public class NearstModel extends BaseModel {
	/**
	 * 
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = -7899937073002620080L;

	@Id
	@GeneratedValue(generator = "JDBC")
	private Long id;

	private String month;

	private String letter;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * @param month
	 *            the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * @return the letter
	 */
	public String getLetter() {
		return letter;
	}

	/**
	 * @param letter
	 *            the letter to set
	 */
	public void setLetter(String letter) {
		this.letter = letter;
	}

}
