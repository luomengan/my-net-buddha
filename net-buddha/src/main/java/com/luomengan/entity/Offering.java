package com.luomengan.entity;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.luomengan.entity.dbconverter.OfferingTypeEnumConverter;
import com.luomengan.entity.dbenum.OfferingTypeEnum;

/**
 * 供品
 * 
 * @author luomengan
 *
 */
@Entity
@Table(name = "t_offering")
public class Offering {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 类型
	 */
	@Convert(converter = OfferingTypeEnumConverter.class)
	private OfferingTypeEnum type;
	/**
	 * 需消耗的功德
	 */
	private Integer meritValue;
	/**
	 * 寓意
	 */
	private String meaning;
	/**
	 * 供品图链接
	 */
	private String link;
	/**
	 * 供品小图链接
	 */
	private String smallLink;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public OfferingTypeEnum getType() {
		return type;
	}

	public void setType(OfferingTypeEnum type) {
		this.type = type;
	}

	public Integer getMeritValue() {
		return meritValue;
	}

	public void setMeritValue(Integer meritValue) {
		this.meritValue = meritValue;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getSmallLink() {
		return smallLink;
	}

	public void setSmallLink(String smallLink) {
		this.smallLink = smallLink;
	}

}
