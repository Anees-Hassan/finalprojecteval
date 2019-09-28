package com.ust.model;

//define bean class for vendor details
public class VendorBean {
//declaring properties for storing vendor details
	
	//vendor table
	private int vendorId;
	private String vendorName;
	private String address;
	private String location;
	private String service;
	private String PinCode;
	private int isActive ;
	
	//contact person table
	private int contactId;
	private String name;
	private String dptmt;
	private String email;
	private String phNo;
	
	//define Constructors
	public VendorBean(int vendorId, String vendorName, String address,
			String location, String service, String pinCode, int isActive,
			int contactId, String name, String dptmt, String email, String phNo) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.address = address;
		this.location = location;
		this.service = service;
		PinCode = pinCode;
		this.isActive = isActive;
		this.contactId = contactId;
		this.name = name;
		this.dptmt = dptmt;
		this.email = email;
		this.phNo = phNo;
	}

	//define default Constructors
	public VendorBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	//define all getters and setters
	public int getVendorId() {
		return vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public String getAddress() {
		return address;
	}

	public String getLocation() {
		return location;
	}

	public String getService() {
		return service;
	}

	public String getPinCode() {
		return PinCode;
	}

	public int getIsActive() {
		return isActive;
	}

	public int getContactId() {
		return contactId;
	}

	public String getName() {
		return name;
	}

	public String getDptmt() {
		return dptmt;
	}

	public String getEmail() {
		return email;
	}

	public String getPhNo() {
		return phNo;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setService(String service) {
		this.service = service;
	}

	public void setPinCode(String pinCode) {
		PinCode = pinCode;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDptmt(String dptmt) {
		this.dptmt = dptmt;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}

	//Overriding toString function
	@Override
	public String toString() {
		return "VendorBean [vendorId=" + vendorId + ", vendorName="
				+ vendorName + ", address=" + address + ", location="
				+ location + ", service=" + service + ", PinCode=" + PinCode
				+ ", isActive=" + isActive + ", contactId=" + contactId
				+ ", name=" + name + ", dptmt=" + dptmt + ", email=" + email
				+ ", phNo=" + phNo + "]";
	}
	
	
	
	
	
}
