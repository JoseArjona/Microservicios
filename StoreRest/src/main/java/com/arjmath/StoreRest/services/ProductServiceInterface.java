package com.arjmath.StoreRest.services;

import java.util.List;
import com.arjmath.StoreRest.entity.Product;

public interface ProductServiceInterface {
    public List<Product> findAll();
    public Product findById(Long id);
}
