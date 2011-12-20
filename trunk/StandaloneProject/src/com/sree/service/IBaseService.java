package com.sree.service;

import java.util.List;

public interface IBaseService {
	public void save(Object obj);
	
	public void deletePerson(Integer id);
	
	public String hello(String name);
	
	public Object getObject(Class clazz, Long id);
	
	public List find(String queryName, Object...objects );
	
	public List find(String queryName, Class clazz, Object... objects);
}
