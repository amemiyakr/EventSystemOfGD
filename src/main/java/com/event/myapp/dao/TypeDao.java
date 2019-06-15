package com.event.myapp.dao;

import java.util.List;

import com.event.myapp.domain.Type;

public interface TypeDao {
	List<Type> findAll() throws Exception;

}