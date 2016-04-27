package com.ntgclarity.smartcompound.business.service;

import java.util.List;
import java.util.Map;

import com.ntgclarity.smartcompound.common.entity.Employee;

public interface EmployeeCRUDService {

	Employee insertEmployeeWithListener(Employee employee);

	void insertEmployeeInEmpQueue(Employee employee);

}
