package com.saldivar.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.saldivar.domains.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    /*private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }*/

	List<Product> findByName(String name);
	
	@Query("select p from Product p")
	List<Product> findFirstByCustomQuery();
	
}