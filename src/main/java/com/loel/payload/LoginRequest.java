
package com.loel.payload;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginRequest {

	@NotBlank(message = "Gotta type something Sherlock")
	private String username;
	@NotBlank(message = "Blank is a little to easy to guess try typing a password")
	private String password;
}