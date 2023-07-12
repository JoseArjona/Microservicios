package com.arjmath.SecStore.models.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.arjmath.SecStore.clients.ProductClientRest;
import com.arjmath.SecStore.models.Item;

@Service("serviceFeign")
@Primary
public class ItemServiceFeign implements ItemServiceInterface {
  
    @Autowired
    private ProductClientRest clientFeign;

    @Override
    public List<Item> findAll() {
        return clientFeign.listProducts().stream().map(p -> new Item(p,1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer quantity) {
        return new Item(clientFeign.getProduct(id), quantity);
    }
}
