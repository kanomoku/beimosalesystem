package com.pojo;

import java.math.BigDecimal;

public class Pos {
	private long pos_num;
	private String pos_year;
	private String pos_month;
	private String pos_day;
	private int pos_store_num;
	private String pos_store_remark;
	private long pos_customer_num;
	private String pos_customer_remark;
	private int pos_goods_num;
	private String pos_goods_remark;
	private int pos_quantity;
	private BigDecimal pos_sale_price;
	private BigDecimal pos_total_price;
	private BigDecimal pos_reduced_price;
	private BigDecimal pos_final_price;
	private	long	pos_agency_num	;
	private String pos_remark;
	public long getPos_num() {
		return pos_num;
	}
	public void setPos_num(long pos_num) {
		this.pos_num = pos_num;
	}
	public String getPos_year() {
		return pos_year;
	}
	public void setPos_year(String pos_year) {
		this.pos_year = pos_year;
	}
	public String getPos_month() {
		return pos_month;
	}
	public void setPos_month(String pos_month) {
		this.pos_month = pos_month;
	}
	public String getPos_day() {
		return pos_day;
	}
	public void setPos_day(String pos_day) {
		this.pos_day = pos_day;
	}
	public int getPos_store_num() {
		return pos_store_num;
	}
	public void setPos_store_num(int pos_store_num) {
		this.pos_store_num = pos_store_num;
	}
	public String getPos_store_remark() {
		return pos_store_remark;
	}
	public void setPos_store_remark(String pos_store_remark) {
		this.pos_store_remark = pos_store_remark;
	}
	public long getPos_customer_num() {
		return pos_customer_num;
	}
	public void setPos_customer_num(long pos_customer_num) {
		this.pos_customer_num = pos_customer_num;
	}
	public String getPos_customer_remark() {
		return pos_customer_remark;
	}
	public void setPos_customer_remark(String pos_customer_remark) {
		this.pos_customer_remark = pos_customer_remark;
	}
	public int getPos_goods_num() {
		return pos_goods_num;
	}
	public void setPos_goods_num(int pos_goods_num) {
		this.pos_goods_num = pos_goods_num;
	}
	public String getPos_goods_remark() {
		return pos_goods_remark;
	}
	public void setPos_goods_remark(String pos_goods_remark) {
		this.pos_goods_remark = pos_goods_remark;
	}
	public int getPos_quantity() {
		return pos_quantity;
	}
	public void setPos_quantity(int pos_quantity) {
		this.pos_quantity = pos_quantity;
	}
	public BigDecimal getPos_sale_price() {
		return pos_sale_price;
	}
	public void setPos_sale_price(BigDecimal pos_sale_price) {
		this.pos_sale_price = pos_sale_price;
	}
	public BigDecimal getPos_total_price() {
		return pos_total_price;
	}
	public void setPos_total_price(BigDecimal pos_total_price) {
		this.pos_total_price = pos_total_price;
	}
	public BigDecimal getPos_reduced_price() {
		return pos_reduced_price;
	}
	public void setPos_reduced_price(BigDecimal pos_reduced_price) {
		this.pos_reduced_price = pos_reduced_price;
	}
	public BigDecimal getPos_final_price() {
		return pos_final_price;
	}
	public void setPos_final_price(BigDecimal pos_final_price) {
		this.pos_final_price = pos_final_price;
	}
	public long getPos_agency_num() {
		return pos_agency_num;
	}
	public void setPos_agency_num(long pos_agency_num) {
		this.pos_agency_num = pos_agency_num;
	}
	public String getPos_remark() {
		return pos_remark;
	}
	public void setPos_remark(String pos_remark) {
		this.pos_remark = pos_remark;
	}
	@Override
	public String toString() {
		return "Pos [pos_num=" + pos_num + ", pos_year=" + pos_year + ", pos_month=" + pos_month + ", pos_day="
				+ pos_day + ", pos_store_num=" + pos_store_num + ", pos_store_remark=" + pos_store_remark
				+ ", pos_customer_num=" + pos_customer_num + ", pos_customer_remark=" + pos_customer_remark
				+ ", pos_goods_num=" + pos_goods_num + ", pos_goods_remark=" + pos_goods_remark + ", pos_quantity="
				+ pos_quantity + ", pos_sale_price=" + pos_sale_price + ", pos_total_price=" + pos_total_price
				+ ", pos_reduced_price=" + pos_reduced_price + ", pos_final_price=" + pos_final_price
				+ ", pos_agency_num=" + pos_agency_num + ", pos_remark=" + pos_remark + "]";
	}
	

}
