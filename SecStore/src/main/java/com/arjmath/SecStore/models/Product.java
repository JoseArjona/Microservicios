package com.arjmath.SecStore.models;

import java.util.Date;

public class Product {
    private Long id;
    private String name;
    private Double price;
    private Date createdAt;
    
    private Integer port;  
   
    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
    
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
    
    public Date getCreatedAt() {
        return createdAt;
    }
   
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price){
        this.price = price;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
