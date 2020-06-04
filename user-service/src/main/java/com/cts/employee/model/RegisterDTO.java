package com.cts.employee.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

public class RegisterDTO {

	private int id;
	private String name;
	private int empId;
	private String email;
	private String password;
	private String cpassword;
	private String userType;
	private String business_unit;
	private String location;
	private long phone;
	private String regstatus;
	private boolean active=false;
	private boolean accept=false;
	public RegisterDTO() {
		super();
	}
	
	public RegisterDTO(int id, String name, int empId, String email, String password, String cpassword, String userType,
			String business_unit, String location, long phone, String regstatus, boolean active, boolean accept) {
		super();
		this.id = id;
		this.name = name;
		this.empId = empId;
		this.email = email;
		this.password = password;
		this.cpassword = cpassword;
		this.userType = userType;
		this.business_unit = business_unit;
		this.location = location;
		this.phone = phone;
		this.regstatus = regstatus;
		this.active = active;
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
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getBusiness_unit() {
		return business_unit;
	}
	public void setBusiness_unit(String business_unit) {
		this.business_unit = business_unit;
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
	public String getRegstatus() {
		return regstatus;
	}
	public void setRegstatus(String regstatus) {
		this.regstatus = regstatus;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public boolean isAccept() {
		return accept;
	}

	public void setAccept(boolean accept) {
		this.accept = accept;
	}

	@Override
	public String toString() {
		return "RegisterDTO [id=" + id + ", name=" + name + ", empId=" + empId + ", email=" + email + ", password="
				+ password + ", cpassword=" + cpassword + ", userType=" + userType + ", business_unit=" + business_unit
				+ ", location=" + location + ", phone=" + phone + ", regstatus=" + regstatus + ", active=" + active
				+ ", accept=" + accept + "]";
	}

	
	
}
