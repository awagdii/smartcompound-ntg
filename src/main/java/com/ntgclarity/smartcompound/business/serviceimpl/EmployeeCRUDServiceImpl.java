package com.ntgclarity.smartcompound.business.serviceimpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntgclarity.smartcompound.business.service.EmployeeCRUDService;
import com.ntgclarity.smartcompound.business.service.EmployeeService;
import com.ntgclarity.smartcompound.common.entity.Employee;
import com.ntgclarity.smartcompound.dataaccess.dao.EmployeeDAO;

@Service
public class EmployeeCRUDServiceImpl implements EmployeeCRUDService {

	@Autowired
	private EmployeeDAO employeeDAO;
	Queue<Employee> employeeQueue = new LinkedList<Employee>();
	private Queue<Employee> employeeQueueFail = new LinkedList<Employee>();
	Iterator it = employeeQueue.iterator();

	public Queue<Employee> getEmployeeQueue() {
		return employeeQueue;
	}

	public void setEmployeeQueue(Queue<Employee> employeeQueue) {
		this.employeeQueue = employeeQueue;
	}

	public Queue<Employee> getEmployeeQueueFail() {
		return employeeQueueFail;
	}

	public void setEmployeeQueueFail(Queue<Employee> employeeQueueFail) {
		this.employeeQueueFail = employeeQueueFail;
	}

	@PostConstruct
	public void init() {

		new Thread(new Runnable() {
			public void run() {
				while (true) {

					while (it.hasNext()) {
						try {
							// System.out.println("Queue peek :"
							// + employeeQueue.peek());
							insertEmployeeWithListener(employeeQueue.peek());
							employeeQueue.poll();
						} catch (Exception e) {

							employeeQueueFail.add(employeeQueue.poll());
						}
					}

					try {
						Thread.sleep(1000);
					} catch (Exception e) {
					}

				}
			}
		}).start();
	}

	@Override
	public Employee insertEmployeeWithListener(Employee employee) {

		return employeeDAO.insertEmployee(employee);
	}

	@Override
	public void insertEmployeeInEmpQueue(Employee employee) {

		employeeQueue.add(employee);
		System.out.println("add" + employee);
	}

}
