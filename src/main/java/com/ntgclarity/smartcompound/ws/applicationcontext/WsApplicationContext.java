package com.ntgclarity.smartcompound.ws.applicationcontext;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.ntgclarity.smartcompound.ws.controller.EmployeeController;
  
@ApplicationPath(value = "WsApplicationContext")
public class WsApplicationContext extends Application{

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(EmployeeController.class);  
		return classes; 
	}

	
	
}
