package com.example.ovo.manager.managerImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.ovo.dao.UserDao;
import com.example.ovo.manager.UserManager;
import com.example.ovo.model.User;

public class UserManagerImpl implements UserManager{

	@Autowired
	private UserDao userDao;
	
	@Override
	public void createUser(User user) {
		// TODO Auto-generated method stub
		userDao.save(user);
		
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
