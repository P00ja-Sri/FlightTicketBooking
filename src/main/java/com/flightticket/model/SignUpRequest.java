package com.flightticket.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SignUpRequest {
	
	private String userName; 
	private String password;
	private String[] roles;
}
