package com.cos.testblogapp.web.dto;

import com.cos.testblogapp.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JoinReqtDto {
	private String username;
	private String password;
	private String email;
	
	public User toEntity() {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		return user;
	}
}
