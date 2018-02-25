package com.luomengan.entity;

import java.util.Date;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.luomengan.entity.dbconverter.MeritFlowTypeEnumConverter;
import com.luomengan.entity.dbenum.MeritFlowTypeEnum;

/**
 * 用户功德流水
 * 
 * @author luomengan
 *
 */
@Entity
@Table(name = "t_user_merit_flow")
public class UserMeritFlow {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/**
	 * 用户ID
	 */
	private Integer userId;
	/**
	 * 流水号
	 */
	private String flowNo;
	/**
	 * 流水类型
	 */
	@Convert(converter = MeritFlowTypeEnumConverter.class)
	private MeritFlowTypeEnum flowType;
	/**
	 * 功德数
	 */
	private Integer meritValue;
	/**
	 * 创建时间
	 */
	private Date createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFlowNo() {
		return flowNo;
	}

	public void setFlowNo(String flowNo) {
		this.flowNo = flowNo;
	}

	public MeritFlowTypeEnum getFlowType() {
		return flowType;
	}

	public void setFlowType(MeritFlowTypeEnum flowType) {
		this.flowType = flowType;
	}

	public Integer getMeritValue() {
		return meritValue;
	}

	public void setMeritValue(Integer meritValue) {
		this.meritValue = meritValue;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
