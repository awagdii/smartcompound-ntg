package com.ntgclarity.smartcompound.portal.managedbean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.ntgclarity.smartcompound.business.management.SmartCompoundManagment;
import com.ntgclarity.smartcompound.common.entity.Employee;
import com.ntgclarity.smartcompound.portal.base.BaseBean;


@ManagedBean
@ViewScoped
public class EmployeeBean extends BaseBean implements Serializable {

	@ManagedProperty(value = "#{smartCompoundManagmentImpl}")
	private SmartCompoundManagment smartCompoundManagment;

	private LazyDataModel<Employee> lazyEmployeeModel;

	private Employee selectedEmployee;

	
	private static final long serialVersionUID = 1L;

	private List<Employee> allEmployees;

	@PostConstruct
	public void init() {
		loadAllEmployees();
		LoadData();
		
	}

	
	public LazyDataModel<Employee> getLazyEmployeeModel() {
		return lazyEmployeeModel;
	}



	public void setLazyEmployeeModel(LazyDataModel<Employee> lazyEmployeeModel) {
		this.lazyEmployeeModel = lazyEmployeeModel;
	}



	public void loadAllEmployees() {
		allEmployees = smartCompoundManagment.getAllEmployees();
	}

	public void testMethod() {

		loadAllEmployees();
	
		
	}

	public void printEmployee() {
		System.out.println(selectedEmployee);
	}

	public List<Employee> getAllEmployees() {
		return allEmployees;
	}

	public void setAllEmployees(List<Employee> allEmployees) {
		this.allEmployees = allEmployees;
	}

	public SmartCompoundManagment getSmartCompoundManagment() {
		return smartCompoundManagment;
	}

	public void setSmartCompoundManagment(
			SmartCompoundManagment smartCompoundManagment) {
		this.smartCompoundManagment = smartCompoundManagment;
	}

	public Employee getSelectedEmployee() {
		return selectedEmployee;
	}

	public void setSelectedEmployee(Employee selectedEmployee) {
		this.selectedEmployee = selectedEmployee;
	}

	public void LoadData() {
	    lazyEmployeeModel = new LazyDataModel<Employee>() {
	    	private List<Employee> result ;
			

			private static final long serialVersionUID = 1L;

			
		    @Override
		    public Employee getRowData(String rowKey) {
		        for(Employee Employee : result) {
		            if(Employee.getId().equals(rowKey))
		                return Employee;
		        }
		 
		        return null;
		    }
		 
		    @Override
		    public Object getRowKey(Employee Employee) {
		        return Employee.getId();
		    }
			
			@Override    
	        public List<Employee> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
				
	        	
				result= getSmartCompoundManagment().loadEmployees(first,pageSize,sortField,sortOrder==SortOrder.ASCENDING,filters);
				this.setRowCount(getSmartCompoundManagment().getNumOfEmployeesRows(filters));
				
				return result;
	        }
	    };

	
	}


}
