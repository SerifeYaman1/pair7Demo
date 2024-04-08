package com.tobeto.pair7Demo.service.mapper;


import com.tobeto.pair7Demo.entities.Product;
import com.tobeto.pair7Demo.entities.User;
import com.tobeto.pair7Demo.service.dto.requests.product.AddProductRequest;
import com.tobeto.pair7Demo.service.dto.requests.product.UpdateProductRequest;
import com.tobeto.pair7Demo.service.dto.requests.user.AddUserRequest;
import com.tobeto.pair7Demo.service.dto.responses.product.AddProductResponse;
import com.tobeto.pair7Demo.service.dto.responses.product.GetAllProductResponse;
import com.tobeto.pair7Demo.service.dto.responses.product.GetByIdProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    @Mapping(target="category.id", source = "categoryId")
    Product productFromAddRequest(AddProductRequest request);

    @Mapping(target = "categoryName", source = "category.name")
    AddProductResponse productToAddResponse(Product savedProduct);

    @Mapping(target = "categoryName", source = "category.name")
    GetAllProductResponse productToGetAllResponse(Product product);
    @Mapping(target = "categoryName", source = "category.name")
    GetByIdProductResponse productToGetByIdResponse(Product product);
    @Mapping(target="category.id", source = "categoryId")
    Product productFromUpdateRequest(UpdateProductRequest request);
}
