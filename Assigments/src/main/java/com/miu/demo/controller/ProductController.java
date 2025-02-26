//package com.miu.demo.controller;
//
//import com.miu.demo.domain.Product;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/products")//localhost:8080/products
//public class ProductController {
//    @GetMapping
//
//
//    public Product findAll(){
//        Product product = new Product(111,"Iphone",1300);
//        return product;
//    }
//    @GetMapping("/${id}")
//    public Product findById(@PathVariable int id){
//        Product product = new Product(id,"Iphone",1300);
//        return product;
//    }
//}
