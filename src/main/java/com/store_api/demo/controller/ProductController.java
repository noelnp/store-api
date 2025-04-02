package com.store_api.demo.controller;


import com.store_api.demo.model.Category;
import com.store_api.demo.model.Product;
import com.store_api.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;
    
     // Get Endpoints

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @CrossOrigin
    @GetMapping("/frontpage-products")
    public List<Product> getFrontpageProducts() {
        return productService.getFeaturedProducts();
    }
    
    
    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return productService.getAllCategories();
    }
    
    @GetMapping("/categories/{categoryId}/products")
    public List<Product> getProductsByCategory(@PathVariable long categoryId) {
        return productService.getProductsByCategoryId(categoryId);
    }

    // Put Endpoints

//    @PutMapping("/categories")
//    public void addCateogry() {
//
//    }
//
//    @PutMapping("/products")
//    public void addProduct() {
//
//    }
}


