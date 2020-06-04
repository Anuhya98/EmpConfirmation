package com.cts.employee.service;

import java.util.List;

import com.cts.employee.entity.Register;
import com.cts.employee.model.RegisterDTO;

public interface RegisterService {
	public Register insert(Register rd);
	public void deleteById(int id);
	public String activate(String email);
	public Register updateUser(Register users);
	public List<Register> getAllUsers();
	public Register getUserById(int id);
	public RegisterDTO getUserByEmailAndPassword(String email, String password);
	
}
