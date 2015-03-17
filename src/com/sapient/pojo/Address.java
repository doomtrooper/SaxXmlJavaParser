package com.sapient.pojo;

public class Address {
	private int houseNo;
	private int streeNo;
	private String city;
	public int getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}
	public int getStreeNo() {
		return streeNo;
	}
	public void setStreeNo(int streeNo) {
		this.streeNo = streeNo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public Address() {
	}
	
	
	public Address(int houseNo, int streeNo, String city) {
		this.houseNo = houseNo;
		this.streeNo = streeNo;
		this.city = city;
	}
	@Override
	public String toString() {
		return "Address [houseNo=" + houseNo + ", streeNo=" + streeNo
				+ ", city=" + city + "]";
	}
	
}
