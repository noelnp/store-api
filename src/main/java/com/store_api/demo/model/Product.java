package com.store_api.demo.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Long id;
    private String name;
    private int price;
    private String imageLink;
    private Category category;

    public Product(Long id, String name, int price, String imageLink, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageLink = imageLink;
        this.category = category;
    }


}
