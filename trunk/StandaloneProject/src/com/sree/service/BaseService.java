package com.sree.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sree.dao.BaseDao;

@Service("baseService")
public class BaseService implements IBaseService{
	@Autowired
	private BaseDao baseDao;

	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	public void deletePerson(Integer id){
		baseDao.delete(id);
	}
	
	public void save(Object obj){
		baseDao.save(obj);
	}

	@Override
	public String hello(String name) {
		return "Welcome "+name;
	}
	
	public Object getObject(Class clazz, Long id){
		return baseDao.getObject(clazz, id);
	}
	
	public List find(String queryName, Object...objects ){
		return baseDao.find(queryName, objects);
	}

	@Override
	public List find(String queryName, Class clazz, Object... objects) {
		return baseDao.find(queryName, clazz, objects);
	}
}
