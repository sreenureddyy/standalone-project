package com.sree.dao;

import java.util.List;

@SuppressWarnings("unchecked")
public interface BaseDao {

	public void save(Object object);

	public void update(Object object);

	public void delete(Object object);

	public Object getObject(Class clazz, Long id);
	
	public List find(String queryName, Object...objects );
	
	public List find(String queryName, Class clazz, Object... objects);

}
