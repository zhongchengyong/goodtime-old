package com.mySSM.dao;

public interface BaseDao<T> {
	public T get(Integer id);
	public void delete(Integer id);
	public void save(T object);
	public void update(T object);
}
