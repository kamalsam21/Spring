package com.samsung.spring.security.Entity;

import org.hibernate.validator.constraints.NotEmpty;

import com.samsung.spring.security.Annotations.PasswordMatches;
import com.samsung.spring.security.Annotations.ValidEmail;

@PasswordMatches
public class User {

	@NotEmpty(message="UserName cannot be empty!")
	private String username;

	@NotEmpty(message="Email cannot be empty!")
	@ValidEmail
	private String email;

	@NotEmpty(message="Password cannot be empty!")
	private String password;

	private String matchingPassword;

	public String getUsername() {
		return username;
	}

	public void setUsername(String name) {
		this.username = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	@Override
	public String toString() {
		String result = this.username + " " + this.email + " " + this.password;
		return result;
	}
}
