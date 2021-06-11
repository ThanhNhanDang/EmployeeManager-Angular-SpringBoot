package com.java.service;

import java.util.List;

public interface BaseService <T, K>{
	T save (T dto);
	T edit (T dto);
	int delete(K id);
	T find(K id);
	List<T> findAll ();
}
