package com.tobeto.pair7Demo.service.concretes;

import com.tobeto.pair7Demo.entities.Product;
import com.tobeto.pair7Demo.repositories.ProductRepository;
import com.tobeto.pair7Demo.service.abstacts.ProductService;
import com.tobeto.pair7Demo.service.dto.requests.product.AddProductRequest;
import com.tobeto.pair7Demo.service.dto.requests.product.DeleteProductRequest;
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

        Product product = ProductMapper.INSTANCE.productFromAddRequest(request);
        Product savedProduct=productRepository.save(product);
        return ProductMapper.INSTANCE.productToAddResponse(savedProduct);
    }


    @Override
    public void update(UpdateProductRequest request) {
        Optional<Product> productOptional = productRepository.findById(request.getId());
        if (productOptional.isPresent()) {
            Product productToUpdate = productOptional.get();
            // Güncelleme isteğine göre kullanıcı bilgilerini güncelle
            productToUpdate.setName(request.getName());
            // Diğer alanları da güncelleme işlemi burada yapabilirsiniz
            productRepository.save(productToUpdate);
        } else {
            throw new RuntimeException("Kullanıcı bulunamadı.");
        }
    }

    @Override
    public void delete(DeleteProductRequest request) {

        Product product = productRepository.findById(request.getId()).orElseThrow(() -> new RuntimeException("id bulunamadı"));
        productRepository.delete(product);
    }

    @Override
    public List<GetAllProductResponse> getAll() {

        List<Product> products = productRepository.findAll();

        List<GetAllProductResponse> result = new ArrayList<>();

        for (Product product :
                products) {
            GetAllProductResponse dto = new GetAllProductResponse
                    (product.getId(), product.getName(), product.getDescription(),product.getUnitPrice(),
                            product.getUnitsInStock(),product.isActive(),product.getImages(),product.getCategory()
                            );
            result.add(dto);

        }
        return result;
    }
    @Override
    public GetByIdProductResponse getById(int id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            GetByIdProductResponse response = new GetByIdProductResponse();
            response.setId(product.getId());
            response.setName(product.getName());
            // Diğer özelliklerinizi de ekleme işlemini burada yapabilirsiniz.
            return response;
        } else {
            throw new RuntimeException("Kullanıcı id'si bulunamadı.");
        }
    }


}