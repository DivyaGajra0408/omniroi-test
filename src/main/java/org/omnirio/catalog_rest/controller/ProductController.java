package org.omnirio.catalog_rest.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.omnirio.catalog_rest.dao.AttributeKeyRepository;
import org.omnirio.catalog_rest.dao.CategoryRepository;
import org.omnirio.catalog_rest.dao.ProductRepository;
import org.omnirio.catalog_rest.dto.ProductDTO;
import org.omnirio.catalog_rest.entity.AttributeKey;
import org.omnirio.catalog_rest.entity.AttributeVal;
import org.omnirio.catalog_rest.entity.Category;
import org.omnirio.catalog_rest.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private AttributeKeyRepository attributeKeyRepository;

	@PostMapping("/product")
	Product newProduct(@RequestBody ProductDTO product) {
		Category cat = categoryRepository.findById(product.getCategoryId()).orElseThrow(
				() -> new IllegalStateException("Category does not exist."));
		List<AttributeVal> attributes = product.getAttributes().stream().map(attr -> 
			{
				AttributeKey attrKey = attributeKeyRepository.findByNameAndCategoryId(attr.getName(), cat.getId());
				if(cat.getAttributes().contains(attrKey) ) {
					return new AttributeVal(attrKey, attr.getValue());
				} else {
					throw new IllegalStateException(String.format("Attribute : %s is not supported by category : %s"
							, attr.getName(), cat.getName()));
				}
			}).collect(Collectors.toList());
		Product pr = new Product(product.getName(), cat, attributes);
		
		return productRepository.save(pr);
	}

	@GetMapping("/product/{id}")
	Product find(@PathVariable Long id) {
		return productRepository.findById(id).get();
	}
	
}
