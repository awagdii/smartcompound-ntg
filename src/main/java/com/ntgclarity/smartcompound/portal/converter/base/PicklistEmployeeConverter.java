package com.ntgclarity.smartcompound.portal.converter.base;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.ntgclarity.smartcompound.business.management.SmartCompoundManagment;
import com.ntgclarity.smartcompound.common.entity.Employee;
import com.ntgclarity.smartcompound.common.utils.Utils;

public class PicklistEmployeeConverter implements Converter {

	@ManagedProperty(value = "#{smartCompoundManagmentImpl}")
	private SmartCompoundManagment smartCompoundManagment;
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String str) {
		if(Utils.isNotEmpty(str) && Utils.isNumericValue(str))
		{
		return smartCompoundManagment.getEmployee(new Long(str));
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object object) {
	
		if(object!=null)
		{
			if(object instanceof Employee)
			{
				Long id = ((Employee)object).getId();
				return id+"";
			}else
			{
				throw new IllegalStateException("object is not instaoce of employee ");
			}
		}
		return "";
	}

}
