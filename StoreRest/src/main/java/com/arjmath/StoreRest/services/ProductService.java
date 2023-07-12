package com.arjmath.StoreRest.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.arjmath.StoreRest.entity.Product;
import com.arjmath.StoreRest.repository.ProductDao;

import jakarta.transaction.Transactional;


@Service
public class ProductService implements ProductServiceInterface {
    @Autowired
    private ProductDao productDao;

    @Override
    @Transactional
    public List<Product> findAll() {
        return (List<Product>) productDao.findAll();
    }

    @Override
    @Transactional
    public Product findById(Long id) {
        return productDao.findById(id).orElse(null);
    }
   
}
