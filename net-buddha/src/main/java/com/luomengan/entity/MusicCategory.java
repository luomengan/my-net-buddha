package com.luomengan.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * 佛音类别 实体
 * 
 * @author luomengan
 *
 */
@Entity
@Table(name = "t_music_category")
public class MusicCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * 名称
	 */
	private String name;
	/**
	 * 作者
	 */
	private String author;
	/**
	 * 封面
	 */
	private String coverLink;
	/**
	 * 描述
	 */
	private String txtDescription;
	/**
	 * 层级
	 */
	private Integer level;
	/**
	 * 是否首页顶部推荐
	 */
	private Boolean isHomeTop;
	/**
	 * 首页顶部推荐排序
	 */
	private Integer homeTopSortNum;
	/**
	 * 是否推荐
	 */
	private Boolean isRecommend;
	/**
	 * 排序
	 */
	private Integer sortNum;
	/**
	 * 父级类别
	 */
	private Integer parentId;
	/**
	 * 播放次数
	 */
	private Integer playTimes;

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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTxtDescription() {
		return txtDescription;
	}

	public void setTxtDescription(String txtDescription) {
		this.txtDescription = txtDescription;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Boolean getIsHomeTop() {
		return isHomeTop;
	}

	public void setIsHomeTop(Boolean isHomeTop) {
		this.isHomeTop = isHomeTop;
	}

	public Integer getHomeTopSortNum() {
		return homeTopSortNum;
	}

	public void setHomeTopSortNum(Integer homeTopSortNum) {
		this.homeTopSortNum = homeTopSortNum;
	}

	public Boolean getIsRecommend() {
		return isRecommend;
	}

	public void setIsRecommend(Boolean isRecommend) {
		this.isRecommend = isRecommend;
	}

	public Integer getSortNum() {
		return sortNum;
	}

	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getPlayTimes() {
		return playTimes;
	}

	public void setPlayTimes(Integer playTimes) {
		this.playTimes = playTimes;
	}

	public String getCoverLink() {
		return coverLink;
	}

	public void setCoverLink(String coverLink) {
		this.coverLink = coverLink;
	}

}
