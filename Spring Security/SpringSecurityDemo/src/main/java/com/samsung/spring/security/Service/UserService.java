package com.samsung.spring.security.Service;

import com.samsung.spring.security.Entity.User;

public interface UserService {
	
	public void insertUser(User user);

	public User getUserByName(String name);
}
