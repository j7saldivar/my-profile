package com.saldivar.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.saldivar.domain.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

	Product findByName(String name);
	
}