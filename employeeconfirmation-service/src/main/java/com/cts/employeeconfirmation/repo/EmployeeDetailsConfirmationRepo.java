package com.cts.employeeconfirmation.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.employeeconfirmation.entity.EmployeeDetailsConfirmationEntity;

public interface EmployeeDetailsConfirmationRepo extends JpaRepository<EmployeeDetailsConfirmationEntity, Integer>{
	public List<EmployeeDetailsConfirmationEntity> findByBusinessUnit(String businessUnit);
	public List<EmployeeDetailsConfirmationEntity> findByLocation(String location);
	@Query( value = "from EmployeeDetailsConfirmationEntity e where accept = FALSE")
	public List<EmployeeDetailsConfirmationEntity> findDefaultersList();
	@Query( value = "from EmployeeDetailsConfirmationEntity e where accept = FALSE and e.businessUnit = ?1")
	public List<EmployeeDetailsConfirmationEntity> findDefaultersListByBusinessUnit(String businessUnit);
	@Query( value = "from EmployeeDetailsConfirmationEntity e where accept= FALSE and e.location = ?1")
	public List<EmployeeDetailsConfirmationEntity> findDefaultersListByLocation(String location);

}
