package com.cts.employee.entity;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.stereotype.Component;
@Entity
@Table(name="employeedetails")

public class Register implements Serializable{
	private static final long serialVersionUID = 3274366458219631237L;
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int empId;
	private String email;
	private String password;
	private String cpassword;
	private String business_unit;
	private String location;
	private long phone;
	private String userType="ROLE_USER";
	private boolean accept=false;
	

	@Transient
	private String regstatus;
	@Transient
	private boolean active=false;
	public Register() {
		super();
	}
	
	public Register(int id, String name, int empId, String email, String password, String cpassword,
			String business_unit, String location, long phone, String userType, boolean accept, String regstatus,
			boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.empId = empId;
		this.email = email;
		this.password = password;
		this.cpassword = cpassword;
		this.business_unit = business_unit;
		this.location = location;
		this.phone = phone;
		this.userType = userType;
		this.accept = accept;
		this.regstatus = regstatus;
		this.active = active;
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
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
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
		return "Register [id=" + id + ", name=" + name + ", empId=" + empId + ", email=" + email + ", password="
				+ password + ", cpassword=" + cpassword + ", business_unit=" + business_unit + ", location=" + location
				+ ", phone=" + phone + ", userType=" + userType + ", accept=" + accept + ", regstatus=" + regstatus
				+ ", active=" + active + "]";
	}

	
	
	
	}