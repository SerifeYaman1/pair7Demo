package com.tobeto.pair7Demo.service.dto.requests.product;

import com.tobeto.pair7Demo.entities.Category;
import com.tobeto.pair7Demo.entities.Image;
import com.tobeto.pair7Demo.entities.ProductSupplier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProductRequest {

    private String name;

    private String description;

    private double unitPrice;

    private int unitsInStock;

    private boolean isActive;

    private List<Image> images;

    private Category category;


}