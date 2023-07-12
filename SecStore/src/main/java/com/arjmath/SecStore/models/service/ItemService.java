package com.arjmath.SecStore.models.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.arjmath.SecStore.models.Item;
import com.arjmath.SecStore.models.Product;

@Service("serviceRestTemplate")
public class ItemService implements ItemServiceInterface{
    
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Item> findAll(){
        List<Product> products = Arrays.asList(restTemplate.getForObject("http://StoreRest/products", Product[].class));
        return products.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer quantity){
        Map<String, String> pathVariables = new HashMap<String, String>();
        pathVariables.put("id", id.toString());
        Product product = restTemplate.getForObject("http://StoreRest/products/{id}", Product.class, pathVariables);
        return new Item(product, quantity);
    }

}
