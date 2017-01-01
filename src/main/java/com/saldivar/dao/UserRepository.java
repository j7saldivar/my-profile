package com.saldivar.dao;

import org.springframework.data.repository.CrudRepository;

import com.saldivar.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	User findByUsername(String username);

}