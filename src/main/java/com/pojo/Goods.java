package com.pojo;

import java.math.BigDecimal;

public class Goods {
	private int goods_num;
	private String goods_name;
	private String goods_flavor;
	private String goods_category;
	private int goods_specification;
	private int goods_expiration_date;
	private String goods_plant;
	private String goods_legal_person;
	private BigDecimal goods_mill_price;
	private BigDecimal goods_first_class_agent_price;
	private BigDecimal goods_second_class_agent_price;
	private BigDecimal goods_third_class_agent_price;
	private BigDecimal goods_store_purchase_price;
	private BigDecimal goods_sale_price;
	private String goods_remark;
	public int getGoods_num() {
		return goods_num;
	}
	public void setGoods_num(int goods_num) {
		this.goods_num = goods_num;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public String getGoods_flavor() {
		return goods_flavor;
	}
	public void setGoods_flavor(String goods_flavor) {
		this.goods_flavor = goods_flavor;
	}
	public String getGoods_category() {
		return goods_category;
	}
	public void setGoods_category(String goods_category) {
		this.goods_category = goods_category;
	}
	public int getGoods_specification() {
		return goods_specification;
	}
	public void setGoods_specification(int goods_specification) {
		this.goods_specification = goods_specification;
	}
	public int getGoods_expiration_date() {
		return goods_expiration_date;
	}
	public void setGoods_expiration_date(int goods_expiration_date) {
		this.goods_expiration_date = goods_expiration_date;
	}
	public String getGoods_plant() {
		return goods_plant;
	}
	public void setGoods_plant(String goods_plant) {
		this.goods_plant = goods_plant;
	}
	public String getGoods_legal_person() {
		return goods_legal_person;
	}
	public void setGoods_legal_person(String goods_legal_person) {
		this.goods_legal_person = goods_legal_person;
	}
	public BigDecimal getGoods_mill_price() {
		return goods_mill_price;
	}
	public void setGoods_mill_price(BigDecimal goods_mill_price) {
		this.goods_mill_price = goods_mill_price;
	}
	public BigDecimal getGoods_first_class_agent_price() {
		return goods_first_class_agent_price;
	}
	public void setGoods_first_class_agent_price(BigDecimal goods_first_class_agent_price) {
		this.goods_first_class_agent_price = goods_first_class_agent_price;
	}
	public BigDecimal getGoods_second_class_agent_price() {
		return goods_second_class_agent_price;
	}
	public void setGoods_second_class_agent_price(BigDecimal goods_second_class_agent_price) {
		this.goods_second_class_agent_price = goods_second_class_agent_price;
	}
	public BigDecimal getGoods_third_class_agent_price() {
		return goods_third_class_agent_price;
	}
	public void setGoods_third_class_agent_price(BigDecimal goods_third_class_agent_price) {
		this.goods_third_class_agent_price = goods_third_class_agent_price;
	}
	public BigDecimal getGoods_store_purchase_price() {
		return goods_store_purchase_price;
	}
	public void setGoods_store_purchase_price(BigDecimal goods_store_purchase_price) {
		this.goods_store_purchase_price = goods_store_purchase_price;
	}
	public BigDecimal getGoods_sale_price() {
		return goods_sale_price;
	}
	public void setGoods_sale_price(BigDecimal goods_sale_price) {
		this.goods_sale_price = goods_sale_price;
	}
	public String getGoods_remark() {
		return goods_remark;
	}
	public void setGoods_remark(String goods_remark) {
		this.goods_remark = goods_remark;
	}
	@Override
	public String toString() {
		return "Goods [goods_num=" + goods_num + ", goods_name=" + goods_name + ", goods_flavor=" + goods_flavor
				+ ", goods_category=" + goods_category + ", goods_specification=" + goods_specification
				+ ", goods_expiration_date=" + goods_expiration_date + ", goods_plant=" + goods_plant
				+ ", goods_legal_person=" + goods_legal_person + ", goods_mill_price=" + goods_mill_price
				+ ", goods_first_class_agent_price=" + goods_first_class_agent_price
				+ ", goods_second_class_agent_price=" + goods_second_class_agent_price
				+ ", goods_third_class_agent_price=" + goods_third_class_agent_price + ", goods_store_purchase_price="
				+ goods_store_purchase_price + ", goods_sale_price=" + goods_sale_price + ", goods_remark="
				+ goods_remark + "]";
	}


}
