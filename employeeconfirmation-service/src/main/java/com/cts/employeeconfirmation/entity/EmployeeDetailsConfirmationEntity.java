package com.cts.employeeconfirmation.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "employeedetails")
public class EmployeeDetailsConfirmationEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5318537265539164416L;
	@Id
	@GeneratedValue
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
	
	public EmployeeDetailsConfirmationEntity() {
		super();
	}

	public EmployeeDetailsConfirmationEntity(int id, String name, int empId, String email, String password,
			String cpassword, String businessUnit, String location, long phone, String userType, boolean accept) {
		super();
		this.id = id;
		this.name = name;
		this.empId = empId;
		this.email = email;
		this.password = password;
		this.cpassword = cpassword;
		this.businessUnit = businessUnit;
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

	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
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
