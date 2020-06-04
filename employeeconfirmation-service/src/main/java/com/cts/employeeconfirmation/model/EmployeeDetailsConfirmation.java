package com.cts.employeeconfirmation.model;
public class EmployeeDetailsConfirmation {
	private int id;
	private String name;
	private int empId;
	private String email;
	private String password;
	private String cpassword;
	private String businessUnit;
	private String location;
	private long phone;
	private String userType="ROLE_USER";
	private boolean accept=false;
	public EmployeeDetailsConfirmation() {
		super();
	}
	public EmployeeDetailsConfirmation(int id, String name, int empId, String email, String password, String cpassword,
			String business_unit, String location, long phone, String userType, boolean accept) {
		super();
		this.id = id;
		this.name = name;
		this.empId = empId;
		this.email = email;
		this.password = password;
		this.cpassword = cpassword;
		this.businessUnit = business_unit;
		this.location = location;
		this.phone = phone;
		this.userType = userType;
		this.accept = accept;
	}
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
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	public String getBusiness_unit() {
		return businessUnit;
	}
	public void setBusiness_unit(String business_unit) {
		this.businessUnit = business_unit;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public boolean isAccept() {
		return accept;
	}
	public void setAccept(boolean accept) {
		this.accept = accept;
	}
	
	
}
