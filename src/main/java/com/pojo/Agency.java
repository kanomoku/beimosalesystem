package com.pojo;

public class Agency {
	private long agency_num;
	private String agency_username;
	private String agency_password;
	private String agency_name;
	private String agency_telephone;
	private String agency_gender;
	private String agency_year;
	private String agency_month;
	private String agency_remark;
	public long getAgency_num() {
		return agency_num;
	}
	public void setAgency_num(long agency_num) {
		this.agency_num = agency_num;
	}
	public String getAgency_username() {
		return agency_username;
	}
	public void setAgency_username(String agency_username) {
		this.agency_username = agency_username;
	}
	public String getAgency_password() {
		return agency_password;
	}
	public void setAgency_password(String agency_password) {
		this.agency_password = agency_password;
	}
	public String getAgency_name() {
		return agency_name;
	}
	public void setAgency_name(String agency_name) {
		this.agency_name = agency_name;
	}
	public String getAgency_telephone() {
		return agency_telephone;
	}
	public void setAgency_telephone(String agency_telephone) {
		this.agency_telephone = agency_telephone;
	}
	public String getAgency_gender() {
		return agency_gender;
	}
	public void setAgency_gender(String agency_gender) {
		this.agency_gender = agency_gender;
	}
	public String getAgency_year() {
		return agency_year;
	}
	public void setAgency_year(String agency_year) {
		this.agency_year = agency_year;
	}
	public String getAgency_month() {
		return agency_month;
	}
	public void setAgency_month(String agency_month) {
		this.agency_month = agency_month;
	}
	public String getAgency_remark() {
		return agency_remark;
	}
	public void setAgency_remark(String agency_remark) {
		this.agency_remark = agency_remark;
	}
	@Override
	public String toString() {
		return "Agency [agency_num=" + agency_num + ", agency_username=" + agency_username + ", agency_password="
				+ agency_password + ", agency_name=" + agency_name + ", agency_telephone=" + agency_telephone
				+ ", agency_gender=" + agency_gender + ", agency_year=" + agency_year + ", agency_month=" + agency_month
				+ ", agency_remark=" + agency_remark + "]";
	}

}
