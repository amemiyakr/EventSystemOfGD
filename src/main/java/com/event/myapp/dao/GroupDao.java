package com.event.myapp.dao;

import java.util.List;

import com.event.myapp.domain.Group;

public interface GroupDao {
	List<Group> findAll() throws Exception;
}
