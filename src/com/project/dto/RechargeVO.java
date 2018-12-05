package com.project.dto;

public class RechargeVO {
	private String charge_id;
	private String stu_id;
	private String date;
	private int recharge_mn;
	
	public String getCharge_id() {
		return charge_id;
	}
	public void setCharge_id(String charge_id) {
		this.charge_id = charge_id;
	}
	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getRecharge_mn() {
		return recharge_mn;
	}
	public void setRecharge_mn(int recharge_mn) {
		this.recharge_mn = recharge_mn;
	}

}