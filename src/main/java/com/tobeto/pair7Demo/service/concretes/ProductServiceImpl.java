package com.tobeto.pair7Demo.service.concretes;

import com.tobeto.pair7Demo.core.utils.exceptions.types.BusinessException;
import com.tobeto.pair7Demo.entities.Product;
import com.tobeto.pair7Demo.repositories.ProductRepository;
import com.tobeto.pair7Demo.service.abstacts.ProductService;
import com.tobeto.pair7Demo.service.dto.requests.product.AddProductRequest;
import com.tobeto.pair7Demo.service.dto.requests.product.UpdateProductRequest;
import com.tobeto.pair7Demo.service.dto.responses.product.AddProductResponse;
import com.tobeto.pair7Demo.service.dto.responses.product.GetAllProductResponse;
import com.tobeto.pair7Demo.service.dto.responses.product.GetByIdProductResponse;
import com.tobeto.pair7Demo.service.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public AddProductResponse add(AddProductRequest request) {
        productWithSameNameShouldNotExits(request.getName());

        Product product = ProductMapper.INSTANCE.productFromAddRequest(request);
        Product savedProduct=productRepository.save(product);
        AddProductResponse response = ProductMapper.INSTANCE.productToAddResponse(savedProduct);
        return  response;
    }


    @Override
    public void update(UpdateProductRequest request) {
        Optional<Product> optionalProduct = productRepository.findById(request.getId());
        if (optionalProduct.isPresent()) {
            Product productToUpdate = optionalProduct.get();
            Product updatedProduct = ProductMapper.INSTANCE.productFromUpdateRequest(request);
            productRepository.save(updatedProduct);
        } else {
            throw new BusinessException("Ürün bulunamadı.");
        }
    }

    @Override
    public void delete(int id) {

        Product product = productRepository.findById(id).orElseThrow(() -> new BusinessException("id bulunamadı"));
        productRepository.delete(product);
    }

    @Override
    public List<GetAllProductResponse> getAll() {

        List<Product> products = productRepository.findAll();

        List<GetAllProductResponse> result = new ArrayList<>();

        for (Product product :
                products) {
            GetAllProductResponse dto = ProductMapper.INSTANCE.productToGetAllResponse(product);
            result.add(dto);

        }
        return result;
    }

    @Override
    public GetByIdProductResponse getById(int id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            GetByIdProductResponse response = ProductMapper.INSTANCE.productToGetByIdResponse(product);
            return response;
        } else {
            throw new RuntimeException("Kullanıcı id'si bulunamadı.");
        }
    }

    private void productWithSameNameShouldNotExits(String productName){
        Optional<Product> productWithSameName = productRepository.findByNameIgnoreCase(productName);
        if(productWithSameName.isPresent()){
            throw new BusinessException("Aynı isimde 2 ürün olamaz.");
        }
    }

}