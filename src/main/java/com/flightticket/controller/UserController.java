package com.flightticket.controller;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.flightticket.dao.RoleRepository;
import com.flightticket.dao.UserRepository;
import com.flightticket.model.Role;
import com.flightticket.model.Roles;
import com.flightticket.model.SignUpRequest;
import com.flightticket.model.Users;


@RestController
@RequestMapping("/auth")
public class UserController {
	@Autowired // Marks a constructor, field, setter method, or config method as to be autowired 
	UserRepository repository; 
	@Autowired
	RoleRepository rolerepository;
	@Autowired
	PasswordEncoder encoder;
	
	@PostMapping("/signup") //Annotation for mapping HTTP POST requests onto specific handler methods
	public ResponseEntity<?> userSignup(@RequestBody SignUpRequest signupRequest) {
		if(repository.existsByUsername(signupRequest.getUserName())){
	      return ResponseEntity.badRequest().body("login");
	    }
	   
	    Users user = new Users();
	    Set<Role> roles = new HashSet<>();
	    user.setUsername(signupRequest.getUserName());
	    user.setPassword(encoder.encode(signupRequest.getPassword()));
	    System.out.println("Encoded password--- " + user.getPassword());
	    String[] roleArr = signupRequest.getRoles();
	    
	    if(roleArr == null) {
	      roles.add(rolerepository.findByRoleName(Roles.ROLE_USER).get());
	    }
	    
	    for(String role: roleArr) {
	      switch(role) {
	        case "admin":
	          roles.add(rolerepository.findByRoleName(Roles.ROLE_ADMIN).get());
	          break;
	        case "user":
	          roles.add(rolerepository.findByRoleName(Roles.ROLE_USER).get());
	          break;  
	        default:
	          return ResponseEntity.badRequest().body("Specified role not found");
	      }
	    }
	    user.setRoles(roles);
	    repository.save(user);
	    return ResponseEntity.ok("User signed up successfully");
	}
}

