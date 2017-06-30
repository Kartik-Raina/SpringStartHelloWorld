package com.kartik.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kartik.spring.model.User;

public interface UserRepository extends CrudRepository<User, Long>{

	List<User> findByRole(String role);
}
