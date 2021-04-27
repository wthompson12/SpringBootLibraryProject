package com.cognixia.jump.springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.springboot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	// one of the methods listed in jpa, retrieve all the records/entities from a table
	List<User> findAll();
	Optional<User> findByUsername(String username);
	Optional<User> findById(Long id);
	


}
