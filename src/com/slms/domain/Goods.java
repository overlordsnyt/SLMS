package com.slms.domain;

import java.math.BigDecimal;
/**
 * 商品档案实体
 * @author overlord
 *
 */
public class Goods {
	private int id;
	private String name;
	private BigDecimal price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
