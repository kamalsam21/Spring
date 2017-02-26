package com.samsung.spring.security.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.samsung.spring.security.Entity.User;
import com.samsung.spring.security.Service.UserService;
import com.samsung.spring.security.Utils.Encoder;
import com.samsung.spring.security.mappers.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	@Transactional
	public void insertUser(User user) {
		user.setPassword(Encoder.passwordEncoder(user.getPassword()));
		userMapper.insertUser(user);
	}

	@Override
	public User getUserByName(String name) {
		User user = userMapper.getUserByName(name);
		
		return user;
	}
}
