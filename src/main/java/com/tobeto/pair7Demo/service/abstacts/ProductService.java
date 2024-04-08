package com.tobeto.pair7Demo.service.abstacts;

import com.tobeto.pair7Demo.service.dto.requests.product.AddProductRequest;
import com.tobeto.pair7Demo.service.dto.requests.product.UpdateProductRequest;
import com.tobeto.pair7Demo.service.dto.responses.product.AddProductResponse;
import com.tobeto.pair7Demo.service.dto.responses.product.GetAllProductResponse;
import com.tobeto.pair7Demo.service.dto.responses.product.GetByIdProductResponse;

import java.util.List;

public interface ProductService {

    AddProductResponse add (AddProductRequest request);

    void update(UpdateProductRequest request);
    void delete(int id);
    List<GetAllProductResponse>getAll();
    GetByIdProductResponse getById(int id);
}
