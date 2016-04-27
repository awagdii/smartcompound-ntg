package com.ntgclarity.smartcompound.business.managementimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntgclarity.smartcompound.business.management.SmartCompoundManagment;
import com.ntgclarity.smartcompound.business.service.EmployeeCRUDService;
import com.ntgclarity.smartcompound.business.service.EmployeeService;
import com.ntgclarity.smartcompound.common.entity.Employee;

@Service
public class SmartCompoundManagmentImpl implements SmartCompoundManagment{

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private EmployeeCRUDService employeeCRUDService;
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}


	@Override
	public Employee getEmployee(Long id) {
		return employeeService.getEmployee(id);
	}


	@Override
	public List<Employee> loadEmployees(int first, int pageSize,
			String sortField, boolean ascending, Map<String, Object> filters) {
		return employeeService.loadEmployees(first,pageSize,sortField,ascending,filters);
	}


	@Override
	public int getNumOfEmployeesRows(Map<String, Object> filters) {
		
		return employeeService.getNumOfEmployeesRows(filters);
	}



	@Override
	public void insertEmployeeInEmpQueue(Employee employee) {
		 employeeCRUDService.insertEmployeeInEmpQueue(employee);
	}

}
