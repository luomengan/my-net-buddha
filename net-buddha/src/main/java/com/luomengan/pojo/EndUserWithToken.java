package com.luomengan.pojo;

import com.luomengan.entity.EndUser;
import com.luomengan.entity.dbenum.ConsumeMeritGradeEnum;

public class EndUserWithToken extends EndUser {

	/**
	 * 令牌token
	 */
	private String token;
	/**
	 * 用户当前的功德数
	 */
	private Integer meritValue;
	/**
	 * 用户消耗的功德数
	 */
	private Integer consumeMeritValue;

	public EndUserWithToken() {
	}

	public EndUserWithToken(EndUser endUser) {
		if (endUser != null) {
			this.setBirthday(endUser.getBirthday());
			this.setCreateTime(endUser.getCreateTime());
			this.setGender(endUser.getGender());
			this.setHeadPortraitLink(endUser.getHeadPortraitLink());
			this.setId(endUser.getId());
			this.setIsAnonymous(endUser.getIsAnonymous());
			this.setIsTest(endUser.getIsTest());
			this.setName(endUser.getName());
			this.setPhone(endUser.getPhone());
			this.setRegion(endUser.getRegion());
			this.setUpdateTime(endUser.getUpdateTime());
		}
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getGrade() {
		if (consumeMeritValue != null) {
			if (consumeMeritValue >= ConsumeMeritGradeEnum.Grade5.getMeritValue()) {
				return ConsumeMeritGradeEnum.Grade5.getIndex();
			} else if (consumeMeritValue >= ConsumeMeritGradeEnum.Grade4.getMeritValue()) {
				return ConsumeMeritGradeEnum.Grade4.getIndex();
			} else if (consumeMeritValue >= ConsumeMeritGradeEnum.Grade3.getMeritValue()) {
				return ConsumeMeritGradeEnum.Grade3.getIndex();
			} else if (consumeMeritValue >= ConsumeMeritGradeEnum.Grade2.getMeritValue()) {
				return ConsumeMeritGradeEnum.Grade2.getIndex();
			} else if (consumeMeritValue >= ConsumeMeritGradeEnum.Grade1.getMeritValue()) {
				return ConsumeMeritGradeEnum.Grade1.getIndex();
			}
		}
		return 0;
	}

	public Integer getMeritValue() {
		return meritValue;
	}

	public void setMeritValue(Integer meritValue) {
		this.meritValue = meritValue;
	}

	public Integer getConsumeMeritValue() {
		return consumeMeritValue;
	}

	public void setConsumeMeritValue(Integer consumeMeritValue) {
		this.consumeMeritValue = consumeMeritValue;
	}

}
