
package com.loel.exceptions;

import lombok.Data;

@Data
public class InvalidLoginResponse {
	private String username;
	private String password;

	public InvalidLoginResponse() {
		this.username = "You got something wrong pal";
		this.password = "Yep something is wrong bud";
	}
}