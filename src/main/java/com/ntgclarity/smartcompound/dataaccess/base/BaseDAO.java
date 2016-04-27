package com.ntgclarity.smartcompound.dataaccess.base;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ntgclarity.smartcompound.common.base.BaseEntity;

@Repository
@Transactional
public abstract class BaseDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public Object insert(Object entity) {
		getCurrentSession().persist(entity);
		return entity;
	}
	public Object update(Object entity) {
		getCurrentSession().saveOrUpdate(entity);
		return entity;
	}


	public List getAll(Class cls) {
		Query query = getCurrentSession().createQuery(
				"from " + cls.getCanonicalName());
		List result = query.list();
		return result;
	}

	public Object get(Class<? extends BaseEntity> clazz, Long id) {
		return getCurrentSession().get(clazz, id);
	}
	public List load(Class entityClass, int first, int pageSize,
			String sortField, boolean ascending, Map<String, Object> filters) {
		
		String queryString = "from " + entityClass.getCanonicalName();
		Query query = getCurrentSession().createQuery(queryString);
		query.setFirstResult(first); 
		query.setMaxResults(pageSize);
		List employeeList = query.list();
		return employeeList;
	}
	public int getNumOfRows(Class entityClass,Map<String, Object> filters) {
		String queryString = "select count(*) from " + entityClass.getCanonicalName();
		Query query = getCurrentSession().createQuery(queryString);
		int count = (int) (long) query.uniqueResult();
		return count ;
	}

}
