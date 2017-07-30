package com.aakash.practice.personal.flipkart_prep;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 6/30/17.
 */
public class User {

    private String name;
    private Map<Product, Integer> productMap = new HashMap<>();

    public User(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Product, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<Product, Integer> productMap) {
        this.productMap = productMap;
    }

    public void addProduct(Product product){
        if(productMap.containsKey(product)){
            this.productMap.put(product, productMap.get(product) + 1);
        } else {
            this.productMap.put(product, 1);
        }
    }
}
