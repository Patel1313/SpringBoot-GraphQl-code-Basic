package com.springBootWithGraphQL.myApplication.employeeRepositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springBootWithGraphQL.myApplication.employeeEntity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
