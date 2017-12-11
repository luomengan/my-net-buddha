package com.luomengan.entity;

import java.util.Date;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.luomengan.entity.dbconverter.RatingTypeEnumConverter;
import com.luomengan.entity.dbenum.RatingTypeEnum;

/**
 * 
 * 用户评分 实体
 * 
 * @author luomengan
 *
 */
@Entity
@Table(name = "t_user_rating")
public class UserRating {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * 用户ID
	 */
	private Integer userId;
	/**
	 * 收藏资源ID
	 */
	private Integer resourceId;
	/**
	 * 评分类型
	 */
	@Convert(converter = RatingTypeEnumConverter.class)
	private RatingTypeEnum ratingType;
	/**
	 * 评分时间
	 */
	private Date ratingTime;
	/**
	 * 评分
	 */
	private Double rating;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getResourceId() {
		return resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

	public RatingTypeEnum getRatingType() {
		return ratingType;
	}

	public void setRatingType(RatingTypeEnum ratingType) {
		this.ratingType = ratingType;
	}

	public Date getRatingTime() {
		return ratingTime;
	}

	public void setRatingTime(Date ratingTime) {
		this.ratingTime = ratingTime;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

}
