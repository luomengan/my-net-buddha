package com.luomengan.entity;

import java.util.Date;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.luomengan.entity.dbconverter.FavouriteTypeEnumConverter;
import com.luomengan.entity.dbenum.FavouriteTypeEnum;

/**
 * 
 * 用户收藏 实体
 * 
 * @author luomengan
 *
 */
@Entity
@Table(name = "t_user_favourite")
public class UserFavourite {

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
	 * 收藏类型
	 */
	@Convert(converter = FavouriteTypeEnumConverter.class)
	private FavouriteTypeEnum favouriteType;
	/**
	 * 收藏时间
	 */
	private Date favouriteTime;

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

	public FavouriteTypeEnum getFavouriteType() {
		return favouriteType;
	}

	public void setFavouriteType(FavouriteTypeEnum favouriteType) {
		this.favouriteType = favouriteType;
	}

	public Date getFavouriteTime() {
		return favouriteTime;
	}

	public void setFavouriteTime(Date favouriteTime) {
		this.favouriteTime = favouriteTime;
	}

}
