package com.sree.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository("baseDao")
@SuppressWarnings("unchecked")
public class BaseDaoImpl implements BaseDao {
	@PersistenceContext
	private EntityManager em;

	private Session getSession() {
		return (Session) em.getDelegate();
	}

	public void save(Object object) {
		getSession().saveOrUpdate(object);
	}

	public void update(Object object) {
		em.merge(object);
	}

	public void delete(Object object) {
		em.remove(object);
	}

	public Object getObject(Class clazz, Long id) {
		return em.find(clazz, id);
		// return getSession().load(clazz, id);
	}

	public List find(String queryName, Object... objects) {
		if (queryName == null) {
			throw new IllegalArgumentException("queryName should not be null");
		}
		Query query = null;
		try {
			query = em.createNamedQuery(queryName);

			if (objects != null && objects.length > 0) {
				for (int i = 0; i < objects.length; i++) {
					query.setParameter(i + 1, objects[i]);
				}
			}
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(e.getMessage());
		}
		return query.getResultList();
	}

	public List find(String queryName, Class clazz, Object... objects) {
		SQLQuery  query = (SQLQuery) getSession().getNamedQuery(queryName);
		System.out.println("------------->>>"+query);

		
		SQLQuery  query1 = getSession().createSQLQuery(query.getQueryString());
		
		if (objects != null && objects.length > 0) {
			for (int i = 0; i < objects.length; i++) {
				query1.addScalar(objects[i].toString());
				
			}
		}
		return query.setResultTransformer(Transformers.aliasToBean(clazz)).list();
		
		//return null;
	}
}
