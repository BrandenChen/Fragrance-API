package com.bchen.Fragrance.controller;

import com.bchen.Fragrance.model.Product;
import com.bchen.Fragrance.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    //insert product
    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        Product savedProduct = productService.saveProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    //get single product
    @GetMapping("/product")
    public ResponseEntity<Product> getProduct(@RequestParam(name = "productId")long productId){
        Product product = productService.getProduct(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    //get all
    @GetMapping("/products")
    public List<Product> getProducts(){
        return productService.getProducts();
    }
    //update
    @PatchMapping("/product")
    public ResponseEntity<Product> updateProduct(@RequestParam(name ="productId")long productId, @RequestBody Product product){
        Product updatedProduct = productService.updateProduct(productId, product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }
    //delete
    @DeleteMapping("/product")
    public ResponseEntity<Product> deleteProduct(@RequestParam(name = "productId") long productId){
        Product deletedProduct = productService.deleteProduct(productId);
        return new ResponseEntity<>(deletedProduct, HttpStatus.OK);
    }
    //get by raw SQL

    @GetMapping("/products-by-name")
    public List<Product> getProductsByName(@RequestParam(name = "productName") String productName){
        return productService.getProductsByName(productName);
    }
}



