package com.springBootWithGraphQL.myApplication.employeeController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.springBootWithGraphQL.myApplication.employeeEntity.Employee;
import com.springBootWithGraphQL.myApplication.employeeServices.EmployeeServices;


@CrossOrigin("*")
@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeServices employeeServices;
	
	@QueryMapping("welcome")
	public String welcome() {
		return "Welcome to Bollam Bharath Patel";
	}
	@QueryMapping("findAll")
	public List<Employee> findAll() {
		return employeeServices.findAllEmployess();
	}
	
	@QueryMapping("findById")
	public Employee findById(@PathVariable("id") Integer id) {
		return employeeServices.employeeFindById(id).orElseThrow(()->new RuntimeException("id is not present"));
	}

	@MutationMapping("saveEmployee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeServices.save(employee);
	}
	
	@MutationMapping("updateEmployeeById")
	public Employee updateEmployeeById(@RequestBody Employee employee, @PathVariable("id") Integer id) {
		return employeeServices.employeeUpdateById(id, employee);
	}

	@MutationMapping("deleteEmployee")
	public boolean deleteEmployee(@PathVariable("id") Integer id) {
		return employeeServices.employeeDeleteById(id);
	}
}
