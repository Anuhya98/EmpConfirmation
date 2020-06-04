package com.cts.employeeconfirmation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.employeeconfirmation.entity.EmployeeDetailsConfirmationEntity;
import com.cts.employeeconfirmation.service.EmployeeDetailsConfirmationService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.extern.slf4j.Slf4j;
@RequestMapping("cts/employeeservice")
@RestController
@Slf4j
@EnableHystrix
public class EmployeeDetailsConfirmationController{
	
	@Autowired
	private EmployeeDetailsConfirmationService employeeService;
	
	@Autowired
	Environment environment;
	@GetMapping("/ribbon")
	public String ribbonTest() {
		return "ribbon working and running on port" + environment.getProperty("local.server.port") ;
	}
	
	
	
	@GetMapping("/employee/{empId}")
	@HystrixCommand(fallbackMethod = "errorMessage")
	public ResponseEntity<?> getElementById(@PathVariable int empId){
		try {
			EmployeeDetailsConfirmationEntity emp = employeeService.getEmpById(empId);
//			log.info("Getting the employee by empId --> {}",emp);
			return new ResponseEntity<EmployeeDetailsConfirmationEntity>(emp,HttpStatus.OK);
			
		}
		catch(NoClassDefFoundError e) {
			return new ResponseEntity<String>("No employee found",HttpStatus.NOT_FOUND);
		}
	}
	public ResponseEntity<?> errorMessage(@PathVariable int empId){
		return new ResponseEntity<String>("No employee with such id found",HttpStatus.OK);
	}
	@GetMapping("/employee")
	public ResponseEntity<?> getAllEmployees(){
		List<EmployeeDetailsConfirmationEntity> list = employeeService.getAllEmps();
		if(list.size()>0) {
			return new ResponseEntity<List<EmployeeDetailsConfirmationEntity>>(list,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("No employees found",HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping(value="/employee/getEmployeeByBusinessUnit/{businessUnit}")
	public ResponseEntity<?> getEmpByBusinessUnit(@PathVariable String businessUnit){
		List<EmployeeDetailsConfirmationEntity> emps = employeeService.getEmployeesListByBU(businessUnit);
		if(emps.size() > 0) {
			return new ResponseEntity<List<EmployeeDetailsConfirmationEntity>>(emps,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("No employee found",HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value="/employee/getEmployeeByLocation/{location}")
	public ResponseEntity<?> getEmpByLocation(@PathVariable String location){
		List<EmployeeDetailsConfirmationEntity> emps = employeeService.getEmployeesListByLocation(location);
		if(emps.size() > 0) {
			return new ResponseEntity<List<EmployeeDetailsConfirmationEntity>>(emps,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("No employee found",HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value="/employee/getDefaultersList")
	public ResponseEntity<?> getDefaultersList(){
		List<EmployeeDetailsConfirmationEntity> list = employeeService.getDefaultersList();
		if(list.size() > 0) {
			return new ResponseEntity<List<EmployeeDetailsConfirmationEntity>>(list,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("No employyes found",HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value="/employee/getDefaultersListByBU/{businessUnit}")
	public ResponseEntity<?> getDefaulterslistByBusinessUnit(@PathVariable String businessUnit){
		List<EmployeeDetailsConfirmationEntity> emps = employeeService.getDefaultersListByBU(businessUnit);
		if(emps.size() > 0) {
			return new ResponseEntity<List<EmployeeDetailsConfirmationEntity>>(emps,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("No employee found",HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value="/employee/getDefaultersListByLocation/{location}")
	public ResponseEntity<?> getDefaulterslistByLocation(@PathVariable String location){
		List<EmployeeDetailsConfirmationEntity> emps = employeeService.getDefaultersListByLocation(location);
		if(emps.size() > 0) {
			return new ResponseEntity<List<EmployeeDetailsConfirmationEntity>>(emps,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("No employees found",HttpStatus.NOT_FOUND);
		}
	}
	

}
