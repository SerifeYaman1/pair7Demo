package com.tobeto.pair7Demo.service.mapper;


import com.tobeto.pair7Demo.entities.Product;
import com.tobeto.pair7Demo.entities.User;
import com.tobeto.pair7Demo.service.dto.requests.product.AddProductRequest;
import com.tobeto.pair7Demo.service.dto.requests.user.AddUserRequest;
import com.tobeto.pair7Demo.service.dto.responses.product.AddProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    Product productFromAddRequest(AddProductRequest request);

    AddProductResponse productToAddResponse(Product savedProduct);
}
