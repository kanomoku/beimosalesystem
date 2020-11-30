package com.pojo;

public class Customer {

	private long customer_num;
	private String customer_name;
	private String customer_telephone;
	private String customer_gender;
	private String customer_year;
	private String customer_month;
	private String customer_remark;
	public long getCustomer_num() {
		return customer_num;
	}
	public void setCustomer_num(long customer_num) {
		this.customer_num = customer_num;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getCustomer_telephone() {
		return customer_telephone;
	}
	public void setCustomer_telephone(String customer_telephone) {
		this.customer_telephone = customer_telephone;
	}
	public String getCustomer_gender() {
		return customer_gender;
	}
	public void setCustomer_gender(String customer_gender) {
		this.customer_gender = customer_gender;
	}
	public String getCustomer_year() {
		return customer_year;
	}
	public void setCustomer_year(String customer_year) {
		this.customer_year = customer_year;
	}
	public String getCustomer_month() {
		return customer_month;
	}
	public void setCustomer_month(String customer_month) {
		this.customer_month = customer_month;
	}
	public String getCustomer_remark() {
		return customer_remark;
	}
	public void setCustomer_remark(String customer_remark) {
		this.customer_remark = customer_remark;
	}
	@Override
	public String toString() {
		return "Customer [customer_num=" + customer_num + ", customer_name=" + customer_name + ", customer_telephone="
				+ customer_telephone + ", customer_gender=" + customer_gender + ", customer_year=" + customer_year
				+ ", customer_month=" + customer_month + ", customer_remark=" + customer_remark + "]";
	}


}
