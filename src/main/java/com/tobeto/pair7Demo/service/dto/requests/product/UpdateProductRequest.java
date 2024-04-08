package com.tobeto.pair7Demo.service.dto.requests.product;

import com.tobeto.pair7Demo.entities.Category;
import com.tobeto.pair7Demo.entities.Image;
import com.tobeto.pair7Demo.entities.ProductSupplier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductRequest {

    private int id;

    private String name;

    private String description;

    private double unitPrice;

    private int unitsInStock;

    private boolean isActive;

    //TODO images eklencek

    private int categoryId;
}
