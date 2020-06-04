package com.cts.employee.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.employee.entity.Register;

public interface RegisterRepo extends JpaRepository<Register, Integer>  {
	public Register findByEmail(String email);

	public Register findByEmailAndPassword(String email, String password);

}
