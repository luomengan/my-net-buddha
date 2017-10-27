package com.luomengan.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户功德钱包
 * 
 * @author luomengan
 *
 */
@Entity
@Table(name = "t_user_merit_wallet")
public class UserMeritWallet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/**
	 * 用户ID
	 */
	private Integer userId;
	/**
	 * 功德数
	 */
	private Integer meritValue;
	/**
	 * 更新时间
	 */
	private Date updateTime;

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

	public Integer getMeritValue() {
		return meritValue;
	}

	public void setMeritValue(Integer meritValue) {
		this.meritValue = meritValue;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
