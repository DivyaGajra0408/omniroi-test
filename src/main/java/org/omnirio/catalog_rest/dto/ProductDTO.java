package org.omnirio.catalog_rest.dto;

import java.util.List;

public class ProductDTO {

	private String name;
	
	private long categoryId;
	
	private List<AttributeDTO> attributes;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public List<AttributeDTO> getAttributes() {
		return attributes;
	}
	
}
