package com.example;

import org.springframework.data.repository.CrudRepository;

/**
 * 
 * Automatically generate methods for save, findAll, etc. for Product.
 * 
 */
public interface ProductRepository extends CrudRepository<Product, Long>{

	public Product findByCode(String code);
	
}
