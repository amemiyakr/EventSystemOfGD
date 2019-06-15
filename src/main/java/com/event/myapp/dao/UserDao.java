package com.event.myapp.dao;

import java.util.List;

import com.event.myapp.domain.User;

public interface UserDao {

	List<User> findAll() throws Exception;

	User findById(Integer id) throws Exception;

	void insert(User user) throws Exception;

	void update(User user) throws Exception;

	void delete(User user) throws Exception;

	User findByLoginIdAndLoginPass(String loginId, String loginPass ) throws Exception;

}
