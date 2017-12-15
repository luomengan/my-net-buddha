package com.luomengan.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 佛像
 * 
 * @author luomengan
 *
 */
@Entity
@Table(name = "t_joss")
public class Joss {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/**
	 * 名称
	 */
	private String buddhaName;
	/**
	 * 链接
	 */
	private String link;
	/**
	 * 描述
	 */
	private String txtDescription;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBuddhaName() {
		return buddhaName;
	}

	public void setBuddhaName(String buddhaName) {
		this.buddhaName = buddhaName;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getTxtDescription() {
		return txtDescription;
	}

	public void setTxtDescription(String txtDescription) {
		this.txtDescription = txtDescription;
	}

}
