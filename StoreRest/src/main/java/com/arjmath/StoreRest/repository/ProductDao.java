package com.arjmath.StoreRest.repository;

import com.arjmath.StoreRest.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDao extends CrudRepository<Product, Long> {
    
}
