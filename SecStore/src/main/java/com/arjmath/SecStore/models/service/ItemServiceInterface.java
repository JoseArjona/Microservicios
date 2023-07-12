package com.arjmath.SecStore.models.service;

import java.util.List;

import com.arjmath.SecStore.models.Item;

public interface ItemServiceInterface {
    public List<Item> findAll();
    public Item findById(Long id, Integer quantity);
}
