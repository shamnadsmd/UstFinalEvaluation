package com.ust.beans;

public class Vendor {
	
	
//	Declaring needed variables
	
	private int vendorId;
	private String vendorName;
	private String address;
	private String location;
	private String service;
	private int pincode;
	private int contactID;
	private String contactName;
	private String department;
	private String email;
	private String phone;
	private int isActice;
	
//	Constructors
	
	public Vendor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
//	Getters and setters
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public int getContactID() {
		return contactID;
	}
	public void setContactID(int contactID) {
		this.contactID = contactID;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getIsActice() {
		return isActice;
	}
	public void setIsActice(int isActice) {
		this.isActice = isActice;
	}
	public Vendor(int vendorId, String vendorName, String address,
			String location, String service, int pincode, int contactID,
			String contactName, String department, String email, String phone,
			int isActice) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.address = address;
		this.location = location;
		this.service = service;
		this.pincode = pincode;
		this.contactID = contactID;
		this.contactName = contactName;
		this.department = department;
		this.email = email;
		this.phone = phone;
		this.isActice = isActice;
	}
	@Override
	public String toString() {
		return "Vendor [vendorId=" + vendorId + ", vendorName=" + vendorName
				+ ", address=" + address + ", location=" + location
				+ ", service=" + service + ", pincode=" + pincode
				+ ", contactID=" + contactID + ", contactName=" + contactName
				+ ", department=" + department + ", email=" + email
				+ ", phone=" + phone + ", isActice=" + isActice + "]";
	}
	
	
	
	

}
