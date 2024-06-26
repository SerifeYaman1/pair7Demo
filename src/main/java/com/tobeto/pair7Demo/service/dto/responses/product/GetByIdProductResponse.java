package com.tobeto.pair7Demo.service.dto.responses.product;

import com.tobeto.pair7Demo.entities.Category;
import com.tobeto.pair7Demo.entities.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdProductResponse {

    private int id;

    private String name;

    private String description;

    private double unitPrice;

    private int unitsInStock;

    private boolean isActive;

    //TODO images eklenecek

    private String categoryName;
}
