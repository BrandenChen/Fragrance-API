package com.bchen.Fragrance.service;

import com.bchen.Fragrance.model.Product;
import com.bchen.Fragrance.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public  Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public Product getProduct(Long productId){
        return productRepository.findById(productId).orElseThrow(()->new RuntimeException("404"));
    }

    public  List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product updateProduct(long productId, Product product){
        Product existingProduct = productRepository.findById(productId).orElseThrow(()->new RuntimeException("404"));
        existingProduct.setProductName(product.getProductName());
        existingProduct.setRetailPrice(product.getRetailPrice());
        existingProduct.setScentType(product.getScentType());
        existingProduct.setDescription(product.getDescription());
        return existingProduct;
    }

    public Product deleteProduct(long productId){
        Product existingProduct  = productRepository.findById(productId).orElseThrow(()->new RuntimeException("404"));
        productRepository.deleteById(productId);
        return existingProduct;
    }

    public List<Product> getProductsByName(String productName){
        return productRepository.getProductsByName(productName);
    }
}
