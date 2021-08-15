package org.omnirio.catalog_rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AttributeVal {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	private AttributeKey attrKey;
	
	/*
	 * @ManyToOne
	 * 
	 * @JsonIgnore private Product product;
	 */
	
	private String attrValue;
	
	public AttributeVal() {
	}
	
	

	public AttributeVal(AttributeKey attrKey, String attrValue) {
		super();
		this.attrKey = attrKey;
		this.attrValue = attrValue;
	}

	public Long getId() {
		return id;
	}

	public AttributeKey getAttrKey() {
		return attrKey;
	}

	/*
	 * public Product getProduct() { return product; }
	 */

	public String getAttrValue() {
		return attrValue;
	}
	
	
}
