package com.flightticket.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user_master")
@Getter @Setter 
@NoArgsConstructor @AllArgsConstructor // a default constructor and a parameterized constructor
public class Users {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //for automatic generation of id
	@Column(name = "user_id")
	private int userId;
	
	@Column(name ="username")
	private String username;
	
	@Column(name="password", nullable=false)
	private String password;
	
	@ManyToMany(fetch = FetchType.LAZY)
		@JoinTable(name = "user_role", 
		      joinColumns = @JoinColumn(name="user_id", referencedColumnName="user_id"),
		      inverseJoinColumns = @JoinColumn(name="role_id", referencedColumnName="role_id"))
	
	private Set<Role> roles = new HashSet<>();	
}

