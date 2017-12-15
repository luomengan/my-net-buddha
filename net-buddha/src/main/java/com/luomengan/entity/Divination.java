package com.luomengan.entity;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.luomengan.entity.dbconverter.DivinationTypeEnumConverter;
import com.luomengan.entity.dbenum.DivinationTypeEnum;

/**
 * 灵签
 * 
 * @author luomengan
 *
 */
@Entity
@Table(name = "t_divination")
public class Divination {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/**
	 * 签诗
	 */
	private String poem;
	/**
	 * 解签
	 */
	private String solution;
	/**
	 * 类型
	 */
	@Convert(converter = DivinationTypeEnumConverter.class)
	private DivinationTypeEnum type;
	/**
	 * 引用
	 */
	private String reference;
	/**
	 * 概述
	 */
	private String summarize;
	/**
	 * 签语
	 */
	private String sketch;
	/**
	 * 解签消耗的功德
	 */
	private int meritValue;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPoem() {
		return poem;
	}

	public void setPoem(String poem) {
		this.poem = poem;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public DivinationTypeEnum getType() {
		return type;
	}

	public void setType(DivinationTypeEnum type) {
		this.type = type;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getSummarize() {
		return summarize;
	}

	public void setSummarize(String summarize) {
		this.summarize = summarize;
	}

	public String getSketch() {
		return sketch;
	}

	public void setSketch(String sketch) {
		this.sketch = sketch;
	}

	public int getMeritValue() {
		return meritValue;
	}

	public void setMeritValue(int meritValue) {
		this.meritValue = meritValue;
	}

}
