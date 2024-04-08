package com.tobeto.pair7Demo.controllers;

import com.tobeto.pair7Demo.service.abstacts.ProductService;
import com.tobeto.pair7Demo.service.dto.requests.product.AddProductRequest;
import com.tobeto.pair7Demo.service.dto.requests.product.UpdateProductRequest;
import com.tobeto.pair7Demo.service.dto.responses.product.AddProductResponse;
import com.tobeto.pair7Demo.service.dto.responses.product.GetAllProductResponse;
import com.tobeto.pair7Demo.service.dto.responses.product.GetByIdProductResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getAll")
   public List<GetAllProductResponse> getAll(){

        return productService.getAll();
    }

    @GetMapping("/getbyid/{id}")
    public GetByIdProductResponse getById(@PathVariable("id") int id){

        return productService.getById(id);
    }

    @PostMapping("/add")
    public AddProductResponse add(@RequestBody @Valid AddProductRequest request){
        return productService.add(request);
    }

    @PutMapping("/update")
    public void update(@RequestBody UpdateProductRequest request){
        productService.update(request);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id){
        productService.delete(id);
    }

}
