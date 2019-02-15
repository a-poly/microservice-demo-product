package com.example;

import java.net.URI;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ProductController {

	@Autowired ProductRepository repo;

	
	/**
	 * Get a list of all products:
	 */
	@GetMapping("/products")
	public Iterable<Product> getProducts() {
		return repo.findAll();
	}

	
	/**
	 * Get a specific product:
	 */
	@GetMapping("/products/{code}")
	public HttpEntity<Product> getProduct( @PathVariable String code) {
		Product p = repo.findByCode(code);
	    if (p != null) {
	        return new ResponseEntity<Product>(p, HttpStatus.OK);
	    }
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);		
	}
	
	
	/**
	 * Make a new product on POST:
	 */
	@PostMapping("/products")
	public HttpEntity<Void> createProduct(@RequestBody Product product) {
		repo.save(product);
		
		URI location = ServletUriComponentsBuilder
	       .fromCurrentRequestUri()
	       .path("/{id}")
	       .buildAndExpand(product.getCode())
	       .toUri(); ;

	    return ResponseEntity.created(location).build();		
	}

	
	/**
	 * Change a product on PUT:
	 */
	@PutMapping("/products/{code}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateProduct( @PathVariable String code, @RequestBody Product product) {
		repo.save(product);
	}

	/**
	 * Make a new product on PUT:
	 */
	@DeleteMapping("/products/{code}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProduct(@PathVariable String code) {
		repo.deleteById( repo.findByCode(code).getId() );
	}

	
	
	/**
	 * Here is some built in test data.
	 */
	@PostConstruct
	public void init() {
		repo.save(new Product("AAA", 10, 10 ));
		repo.save(new Product("BBB", 20, 20 ));
		repo.save(new Product("CCC", 30, 30 ));
		repo.save(new Product("DDD", 40, 40 ));
		repo.save(new Product("EEE", 50, 50 ));
	}

}
