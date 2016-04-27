package com.ntgclarity.smartcompound.business.managementimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntgclarity.smartcompound.business.management.SmartCompoundManagment;
import com.ntgclarity.smartcompound.business.service.DepartmentService;
import com.ntgclarity.smartcompound.business.service.EmployeeCRUDService;
import com.ntgclarity.smartcompound.business.service.EmployeeService;
import com.ntgclarity.smartcompound.common.entity.Department;
import com.ntgclarity.smartcompound.common.entity.Employee;

@Service
public class SmartCompoundManagmentImpl implements SmartCompoundManagment {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DepartmentService departmentService;
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

	/**
	 * methodCreater:nessma create Employee this metohd will call
	 * employeeService.insertEmployee
	 **/
	@Override
	public Employee insertEmployee(Employee employee) {

		return employeeService.insertEmployee(employee);
	}

	@Override
	public List<Department> getAllDepartments() {
		return departmentService.getAllDepartments();
	}

	@Override
	public Department getDepartment(Long id) {
		return departmentService.getDepartment(id);
	}

	@Override
	public Department insertDepartment(Department department) {

		return departmentService.insertDepartment(department);
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeService.updateEmployee(employee);

	}
	@Override
	public int getNumOfEmployeesRows(Map<String, Object> filters) {
		
		return employeeService.getNumOfEmployeesRows(filters);
	}



	@Override
	public void insertEmployeeInEmpQueue(Employee employee) {
		 employeeCRUDService.insertEmployeeInEmpQueue(employee);
	}

	@Override
	public List<Employee> loadEmployees(int first, int pageSize,
			String sortField, boolean ascending, Map<String, Object> filters) {
		return employeeService.loadEmployees(first,pageSize,sortField,ascending,filters);
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public EmployeeCRUDService getEmployeeCRUDService() {
		return employeeCRUDService;
	}

	public void setEmployeeCRUDService(EmployeeCRUDService employeeCRUDService) {
		this.employeeCRUDService = employeeCRUDService;
	}
	

	

}
