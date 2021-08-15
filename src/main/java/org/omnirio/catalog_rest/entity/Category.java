package org.omnirio.catalog_rest.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<AttributeKey> attributes;
	
	public Category() {
	}
	
	public Category(String name) {
		super();
		this.name = name;
		this.attributes = new HashSet<>();
	}

	public Category(Long id, String name, Set<AttributeKey> attributes) {
		super();
		this.id = id;
		this.name = name;
		this.attributes = attributes;
	}
	
	public void addAttribute(AttributeKey attrKey) {
		attributes.add(attrKey);
		
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Set<AttributeKey> getAttributes() {
		return attributes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	

}