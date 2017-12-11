package com.luomengan.entity.dbenum;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 功德流水类型
 * 
 * @author luomengan
 *
 */
public enum MeritFlowTypeEnum implements CommonalityEnum {

	ChargeMerit(1, "充值功德"),

	DonationMerit(2, "捐赠功德"),

	Checkin(3, "签到"),

	Divination(4, "求签");

	private static Map<MeritFlowTypeEnum, String> virtualGoodsInfoMap = new HashMap<>();
	private static Map<Integer, MeritFlowTypeEnum> valueMap = new HashMap<>();

	static {
		virtualGoodsInfoMap.put(ChargeMerit, "功德充值");
	}

	static {
		for (MeritFlowTypeEnum _enum : MeritFlowTypeEnum.values()) {
			valueMap.put(_enum.getIndex(), _enum);
		}
	}

	private Integer index;
	private String trade;

	MeritFlowTypeEnum(Integer index, String trade) {
		this.index = index;
		this.trade = trade;
	}

	public static MeritFlowTypeEnum getByIndex(Integer index) {
		MeritFlowTypeEnum result = valueMap.get(index);
		if (result == null) {
			throw new IllegalArgumentException("No element matches " + index);
		}
		return result;
	}

	public static String getByTradeType(MeritFlowTypeEnum meritFlowTypeEnum) {
		return virtualGoodsInfoMap.get(meritFlowTypeEnum);
	}

	@Override
	public Integer getIndex() {
		return index;
	}

	@JsonValue
	public String getTrade() {
		return trade;
	}
}
