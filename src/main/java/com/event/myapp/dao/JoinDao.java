package com.event.myapp.dao;

import java.util.List;

import com.event.myapp.domain.Event;
import com.event.myapp.domain.Join;
import com.event.myapp.domain.User;

public interface JoinDao {

	List<Join> findAll() throws Exception;

	Join findById(Integer id) throws Exception;

	void insert(Join join) throws Exception;

	void update(Join join) throws Exception;

	void delete(Join join) throws Exception;

	List<Join> findByEvent(Event event) throws Exception;

	Join findByUserAndEvent(User user, Event event) throws Exception;

	List<Join>findMyEvent(User user) throws Exception;
}
