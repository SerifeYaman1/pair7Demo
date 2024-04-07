package com.tobeto.pair7Demo.controllers;

import com.tobeto.pair7Demo.entities.Product;
import com.tobeto.pair7Demo.service.abstacts.ProductService;
import com.tobeto.pair7Demo.service.dto.requests.product.AddProductRequest;
import com.tobeto.pair7Demo.service.dto.requests.product.DeleteProductRequest;
import com.tobeto.pair7Demo.service.dto.requests.product.UpdateProductRequest;
import com.tobeto.pair7Demo.service.dto.requests.user.AddUserRequest;
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

    @GetMapping
   public List<GetAllProductResponse> getAll(){

        return productService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdProductResponse getById(int id){
        return productService.getById(id);
    }

    @PostMapping
    public AddProductResponse add(@RequestBody @Valid AddProductRequest request){
        return productService.add(request);
    }

    @PutMapping
    public void update(@RequestBody UpdateProductRequest request){
        productService.update(request);
    }

    @DeleteMapping
    public void delete(@RequestParam DeleteProductRequest request){
        productService.delete(request);
    }

}
