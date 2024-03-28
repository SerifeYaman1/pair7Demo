package com.tobeto.pair7Demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductsController {
    @GetMapping
    public String sayHi(@RequestParam String name){
        return "Ürünün adı: " + name;
    }
}
