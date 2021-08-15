package org.omnirio.catalog_rest.dao;

import org.omnirio.catalog_rest.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
