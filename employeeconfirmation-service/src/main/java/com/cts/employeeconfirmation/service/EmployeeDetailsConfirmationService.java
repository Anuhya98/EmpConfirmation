package com.cts.employeeconfirmation.service;

import java.util.List;

import com.cts.employeeconfirmation.entity.EmployeeDetailsConfirmationEntity;

public interface EmployeeDetailsConfirmationService {
	public EmployeeDetailsConfirmationEntity getEmpById(int empId);
	public List<EmployeeDetailsConfirmationEntity> getAllEmps();
	public List<EmployeeDetailsConfirmationEntity> getEmployeesListByLocation(String location);
	public List<EmployeeDetailsConfirmationEntity> getEmployeesListByBU(String businessUnit);
	public List<EmployeeDetailsConfirmationEntity> getDefaultersList();
	public List<EmployeeDetailsConfirmationEntity> getDefaultersListByLocation(String location);
	public List<EmployeeDetailsConfirmationEntity> getDefaultersListByBU(String businessUnit);
}
