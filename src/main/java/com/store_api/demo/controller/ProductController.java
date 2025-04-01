package com.store_api.demo.controller;


import com.store_api.demo.model.Category;
import com.store_api.demo.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {


    @GetMapping("/frontpage-products")
    public List<Product> getFrontpageProducts() {
        Category category = new Category(1L, "Test");
        Product product = new Product(1L, "Test", 3, "Test.com", category);

        return List.of(product);
    }
}


