
package com.loel.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class JWTLoginSuccessResponse {
	private boolean success;
	private String token;

}