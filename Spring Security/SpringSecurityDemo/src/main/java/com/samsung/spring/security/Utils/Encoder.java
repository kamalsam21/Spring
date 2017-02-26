package com.samsung.spring.security.Utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encoder {

	public static String passwordEncoder(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		
		return hashedPassword;
	}
}
