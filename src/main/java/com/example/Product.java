package com.example;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="product")
public class Product {

	private Long id;
	private String code;
	private BigDecimal price;
	private BigDecimal weight;
	

	public Product() {
		super();
	}

	
	public Product(String code, Integer price, Integer weight) {
		this(code, new BigDecimal(price), new BigDecimal(weight));
	}
	
	
	public Product(String code, Long price, Long weight) {
		this(code, new BigDecimal(price), new BigDecimal(weight));
	}
	
	
	public Product(String code, BigDecimal price, BigDecimal weight) {
		this();
		this.code = code;
		this.price = price;
		this.weight = weight;
	}
	
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getWeight() {
		return weight;
	}
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
	
}
