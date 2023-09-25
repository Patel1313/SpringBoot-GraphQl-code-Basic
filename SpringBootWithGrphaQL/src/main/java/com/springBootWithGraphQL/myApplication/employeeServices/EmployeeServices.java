package com.springBootWithGraphQL.myApplication.employeeServices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBootWithGraphQL.myApplication.employeeEntity.Employee;
import com.springBootWithGraphQL.myApplication.employeeRepositry.EmployeeRepo;

@Service
public class EmployeeServices {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	public List<Employee> findAllEmployess (){
		return employeeRepo.findAll();
	}
	
	public Optional<Employee> employeeFindById(Integer id) {
		return employeeRepo.findById(id);
	}
	
	public Employee save(Employee employee) {
		return employeeRepo.save(employee);
	}
	
	public Employee employeeUpdateById(Integer id, Employee  employee) {
		Optional<Employee> empFindById = employeeRepo.findById(id);
		Employee savedEmployee = new Employee();
		if(empFindById.isPresent()) {
			savedEmployee.setId(id);
			savedEmployee.setFullName(employee.getFullName());
			savedEmployee.setAge(employee.getAge());
			savedEmployee.setAddress(employee.getAddress());
			employeeRepo.save(savedEmployee);
		}
		 return savedEmployee;
	}
	
	public boolean employeeDeleteById(Integer id) {
		employeeRepo.deleteById(id);
		return true;
	}
	
}
