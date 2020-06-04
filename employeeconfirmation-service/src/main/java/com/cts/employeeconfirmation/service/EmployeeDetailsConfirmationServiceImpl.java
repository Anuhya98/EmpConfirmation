package com.cts.employeeconfirmation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.employeeconfirmation.entity.EmployeeDetailsConfirmationEntity;
import com.cts.employeeconfirmation.repo.EmployeeDetailsConfirmationRepo;
import com.cts.employeeconfirmation.service.EmployeeDetailsConfirmationService;

@Service
public class EmployeeDetailsConfirmationServiceImpl implements EmployeeDetailsConfirmationService{
	@Autowired
	EmployeeDetailsConfirmationRepo empDetailsRepo;

	@Override
	public EmployeeDetailsConfirmationEntity getEmpById(int empId) {
		Optional<EmployeeDetailsConfirmationEntity> empList = empDetailsRepo.findById(empId);
		EmployeeDetailsConfirmationEntity emp = empList.get();
		return emp;
	}

	@Override
	public List<EmployeeDetailsConfirmationEntity> getAllEmps() {
		return empDetailsRepo.findAll();
	}

	@Override
	public List<EmployeeDetailsConfirmationEntity> getEmployeesListByLocation(String location) {
		// TODO Auto-generated method stub
		return empDetailsRepo.findByLocation(location);
	}

	@Override
	public List<EmployeeDetailsConfirmationEntity> getEmployeesListByBU(String businessUnit) {
		// TODO Auto-generated method stub
		return empDetailsRepo.findByBusinessUnit(businessUnit);
	}

	@Override
	public List<EmployeeDetailsConfirmationEntity> getDefaultersList() {
		// TODO Auto-generated method stub
		return empDetailsRepo.findDefaultersList();
	}

	@Override
	public List<EmployeeDetailsConfirmationEntity> getDefaultersListByLocation(String location) {
		// TODO Auto-generated method stub
		return empDetailsRepo.findDefaultersListByLocation(location);
	}

	@Override
	public List<EmployeeDetailsConfirmationEntity> getDefaultersListByBU(String businessUnit) {
		// TODO Auto-generated method stub
		return empDetailsRepo.findDefaultersListByBusinessUnit(businessUnit);
	}

	

}
