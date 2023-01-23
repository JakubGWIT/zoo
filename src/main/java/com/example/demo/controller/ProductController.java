package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    private ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/add")
    void addNewProduct(){
        Product product = Product.builder().id(1L).name("produkt").build();
        productService.addNewProduct(product);
    }
    @DeleteMapping("/remove/{name}")
    void deleteProduct(@PathVariable String name){
        productService.delete(name);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

}