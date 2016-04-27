package com.ntgclarity.smartcompound.dataaccess.dao;

import java.util.List;
import java.util.Map;

import com.ntgclarity.smartcompound.common.entity.Employee;

public interface EmployeeDAO {

	List<Employee> getAllEmployees();

	Employee getEmployee(Long id);

	Employee insertEmployee(Employee employee);

	Employee updateEmployee(Employee employee);
	List<Employee> loadEmployees(int first, int pageSize, String sortField,
			boolean ascending, Map<String, Object> filters);

	int getNumOfEmployeesRows(Map<String, Object> filters);

}
