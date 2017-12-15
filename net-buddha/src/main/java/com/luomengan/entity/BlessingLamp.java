package com.luomengan.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 祈福明灯
 * 
 * @author luomengan
 *
 */
@Entity
@Table(name = "t_blessing_lamp")
public class BlessingLamp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 图片链接
	 */
	private String link;
	/**
	 * 图片链接缩略图
	 */
	private String smallLink;
	/**
	 * 寓意
	 */
	private String meaning;
	/**
	 * 功效
	 */
	private String effect;
	/**
	 * 灯油列表
	 */
	@OneToMany(mappedBy = "lamp")
	private List<BlessingLampOil> oilList;

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

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public List<BlessingLampOil> getOilList() {
		return oilList;
	}

	public void setOilList(List<BlessingLampOil> oilList) {
		this.oilList = oilList;
	}

	public String getSmallLink() {
		return smallLink;
	}

	public void setSmallLink(String smallLink) {
		this.smallLink = smallLink;
	}

}
