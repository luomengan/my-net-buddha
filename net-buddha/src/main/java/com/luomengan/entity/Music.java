package com.luomengan.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * 佛音 实体
 * 
 * @author luomengan
 *
 */
@Entity
@Table(name = "t_music")
public class Music {

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
	 * 资源链接
	 */
	private String link;
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
	 * 所属类别
	 */
	private Integer categoryId;
	/**
	 * 播放次数
	 */
	private Integer playTimes;
	/**
	 * 音乐时长
	 */
	private Integer duration;

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
	
	public String getLink() {
		return link;
	}
	
	public void setLink(String link) {
		this.link = link;
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
	
	public Integer getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
	public Integer getPlayTimes() {
		return playTimes;
	}
	
	public void setPlayTimes(Integer playTimes) {
		this.playTimes = playTimes;
	}
	
	public Integer getDuration() {
		return duration;
	}
	
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	
}
