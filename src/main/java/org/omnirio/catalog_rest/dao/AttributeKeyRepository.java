package org.omnirio.catalog_rest.dao;

import org.omnirio.catalog_rest.entity.AttributeKey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeKeyRepository extends CrudRepository<AttributeKey, Long> {
	AttributeKey findByNameAndCategoryId(String name, long category_id);
}
