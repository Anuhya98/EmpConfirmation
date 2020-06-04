package com.cts.employee.controller;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
@RibbonClient(name="employeeconfirmation-service")
@FeignClient("employeeconfirmation-service")
public interface EmployeeConfirmationServiceProxy {
	@GetMapping("cts/employeeservice/employee")
	public ResponseEntity<?> getAllEmployees();
	@GetMapping("cts/employeeservice/ribbon")
	public String ribbonTest();
}