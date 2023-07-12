package com.arjmath.StoreRest.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.arjmath.StoreRest.services.ProductServiceInterface;
import com.arjmath.StoreRest.entity.Product;


@RestController
public class ProductController {

    @Value("${server.port}")
    private Integer port;

    @Autowired
    private ProductServiceInterface productService;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.findAll().stream().map(product ->{
            product.setPort(port);
            return product;
        }).collect(Collectors.toList());
        
    }
    
    @GetMapping("/products/{id}")
    public Product getProductId(@PathVariable Long id) {
        Product product = productService.findById(id);
        product.setPort(port);
        boolean ok = (product != null);
        if (!ok) {
            throw new RuntimeException("No se pudo cargar el producto");
        }
        return product;
    }
}
