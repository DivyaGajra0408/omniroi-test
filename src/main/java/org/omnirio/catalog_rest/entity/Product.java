package org.omnirio.catalog_rest.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	@ManyToOne
	private Category category;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<AttributeVal> attributes;

	public Product() {
		super();
	}

	public Product(String name, Category category, List<AttributeVal> attributes) {
		super();
		this.name = name;
		this.category = category;
		this.attributes = attributes;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Category getCategory() {
		return category;
	}

	public List<AttributeVal> getAttributes() {
		return attributes;
	}
	
	
}
