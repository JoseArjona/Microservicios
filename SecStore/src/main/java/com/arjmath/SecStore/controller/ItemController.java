package com.arjmath.SecStore.controller;

import org.springframework.web.bind.annotation.RestController;

import com.arjmath.SecStore.models.Item;
import com.arjmath.SecStore.models.Product;
import com.arjmath.SecStore.models.service.ItemServiceInterface;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.beans.factory.annotation.Qualifier; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable; 


@RestController
public class ItemController {
    @Autowired
    @Qualifier("serviceRestTemplate")
    private ItemServiceInterface itemService;

    @GetMapping("/items")
    public List<Item> geItems(){
        return itemService.findAll();
    }
    
    @HystrixCommand(fallbackMethod = "geItemAlternative")
    @GetMapping("/items/{id}/quantity/{quantity}")
    public Item geItem(@PathVariable Long id, @PathVariable Integer quantity){
        return itemService.findById(id, quantity);
    }

    public Item geItemAlternative(Long id, Integer quantity){
        Item item = new Item();
        Product product = new Product();
        item.setQuantity(quantity);
        product.setId(id);
        product.setName("Camara Sony");
        product.setPrice(500.00);
        item.setProduct(product);
        return item;
    }
}
