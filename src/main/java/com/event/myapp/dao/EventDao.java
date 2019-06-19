package com.event.myapp.dao;

import java.util.List;

import com.event.myapp.domain.Event;
import com.event.myapp.domain.User;

public interface EventDao {

	List<Event> findAll() throws Exception;

	List<Event> findEventOfToday() throws Exception;

	Event findById(Integer id) throws Exception;

	void insert(Event event) throws Exception;

	void update(Event event) throws Exception;

	void delete(Event event) throws Exception;

	List<Event> findMyEvent(User user) throws Exception;

	List<Event> findNeedToMail(String tomail) throws Exception;
}
