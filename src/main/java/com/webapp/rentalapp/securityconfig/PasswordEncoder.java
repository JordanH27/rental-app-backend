package com.webapp.rentalapp.securityconfig;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
	public static void main(String[] argrs) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = "test";
		String encodedPassword = encoder.encode(rawPassword);
		System.out.println(encodedPassword);
	}
}
