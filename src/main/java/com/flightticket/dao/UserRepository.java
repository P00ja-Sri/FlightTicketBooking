package com.flightticket.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.flightticket.model.Users;

@Repository //Indicates that an annotated class is a "Repository"
public interface UserRepository extends JpaRepository<Users,Integer> {
	Users findByUsername(String username);
	public boolean existsByUsername(String username);
}

