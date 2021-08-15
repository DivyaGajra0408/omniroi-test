package org.omnirio.catalog_rest.controller;

import org.omnirio.catalog_rest.dao.CategoryRepository;
import org.omnirio.catalog_rest.dto.AttributeKeyDTO;
import org.omnirio.catalog_rest.entity.AttributeKey;
import org.omnirio.catalog_rest.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;

	@PostMapping("/category")
	Category newCategory(@RequestBody Category category) {
		return categoryRepository.save(category);
	}

	@GetMapping("/category/{id}")
	Category find(@PathVariable Long id) {
		//return new Category(1l, "test");
		return categoryRepository.findById(id).get();
	}
	
	@PostMapping("/category/{id}/add-attribute")
	Category addAttribute(@PathVariable Long id, @RequestBody AttributeKeyDTO attributeKeyDTO) {
		Category cat = categoryRepository.findById(id).orElseThrow(
				() -> new IllegalStateException("Category does not exist."));
		cat.addAttribute(new AttributeKey(attributeKeyDTO.getName(), cat));
		return categoryRepository.save(cat);
	}
}
