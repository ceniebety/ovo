package com.example.ovo.dao;

import java.util.List;

import com.example.ovo.model.User;

public interface UserDao {

	public void save(User user);
	
	public void update(User user);
	
	public void delete(long id);
	
	public List<User> getAll();
	
}
