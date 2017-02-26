package com.samsung.spring.security.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.samsung.spring.security.Entity.User;

public interface UserMapper {
	@Insert("INSERT INTO users(username, email, password) VALUES"
			+ "(#{username}, #{email}, #{password})")
	public void insertUser(User user);

	@Select("SELECT username, email, password FROM users WHERE username = #{name}")
	public User getUserByName(String name);
}
