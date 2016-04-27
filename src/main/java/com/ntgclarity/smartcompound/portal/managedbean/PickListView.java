package com.ntgclarity.smartcompound.portal.managedbean;

import org.primefaces.model.DualListModel;

import com.ntgclarity.smartcompound.business.management.SmartCompoundManagment;
import com.ntgclarity.smartcompound.common.entity.Employee;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class PickListView {
	@ManagedProperty(value = "#{smartCompoundManagmentImpl}")
	private SmartCompoundManagment smartCompoundManagment;

	private DualListModel<Employee> employees;

	public SmartCompoundManagment getSmartCompoundManagment() {
		return smartCompoundManagment;
	}

	public void setSmartCompoundManagment(
			SmartCompoundManagment smartCompoundManagment) {
		this.smartCompoundManagment = smartCompoundManagment;
	}

	public DualListModel<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(DualListModel<Employee> employees) {
		this.employees = employees;
	}

	@PostConstruct
	public void init() {
		List<Employee> employeeSource = new ArrayList<Employee>();
		List<Employee> employeeTarget = new ArrayList<Employee>();
		employeeSource.addAll(smartCompoundManagment.getAllEmployees());
		employees=new DualListModel<>(employeeSource, employeeTarget);
	}

}
