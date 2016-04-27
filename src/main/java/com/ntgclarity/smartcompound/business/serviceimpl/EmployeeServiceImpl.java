package com.ntgclarity.smartcompound.business.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntgclarity.smartcompound.business.service.EmployeeService;
import com.ntgclarity.smartcompound.common.entity.Employee;
import com.ntgclarity.smartcompound.dataaccess.dao.EmployeeDAO;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	private static  List<Employee> employeeQueue=new ArrayList<Employee>();;
	private List<Employee> employeeQueueFail;
	public List<Employee> getEmployeeQueueFail() {
		return employeeQueueFail;
	}

	public void setEmployeeQueueFail(List<Employee> employeeQueueFail) {
		this.employeeQueueFail = employeeQueueFail;
	}

	public List<Employee> getEmployeeQueue() {
		return employeeQueue;
	}

	public void setEmployeeQueue(List<Employee> employeeQueue) {
		this.employeeQueue = employeeQueue;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDAO.getAllEmployees();
	}

	@Override
	public Employee getEmployee(Long id) {
		if(id !=null)
		{
			return employeeDAO.getEmployee(id);
		}
		return null;
	}

	@Override
	public List<Employee> loadEmployees(int first, int pageSize,
			String sortField, boolean ascending, Map<String, Object> filters) {
		return employeeDAO.loadEmployees(first,pageSize,sortField,ascending,filters);
	}

	@Override
	public int getNumOfEmployeesRows(Map<String, Object> filters) {
	
		return  employeeDAO.getNumOfEmployeesRows(filters);
	}

	
	
}
