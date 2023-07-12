package com.arjmath.SecStore.controller;

import org.springframework.web.bind.annotation.RestController;

import com.arjmath.SecStore.models.Item;
import com.arjmath.SecStore.models.service.ItemServiceInterface;

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

    @GetMapping("/items/{id}/quantity/{quantity}")
    public Item geItem(@PathVariable Long id, @PathVariable Integer quantity){
        return itemService.findById(id, quantity);
    }
}
