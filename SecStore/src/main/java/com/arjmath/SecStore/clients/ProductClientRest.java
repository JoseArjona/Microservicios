package com.arjmath.SecStore.clients;
import java.util.List; 
 
import org.springframework.cloud.openfeign.FeignClient; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable;

import com.arjmath.SecStore.models.Product; 

@FeignClient(name = "StoreRest")
public interface ProductClientRest {
    @GetMapping("/products")
    public List<Product> listProducts();

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable Long id);
}
