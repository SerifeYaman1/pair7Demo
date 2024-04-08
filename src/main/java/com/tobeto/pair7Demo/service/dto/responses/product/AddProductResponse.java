package com.tobeto.pair7Demo.service.dto.responses.product;

import com.tobeto.pair7Demo.entities.Category;
import com.tobeto.pair7Demo.entities.Image;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddProductResponse {

    private int id;

    private String name;

    private String description;
    @Min(value = 0,message = "Ürün fıyatı negatif olmaz.")
    private double unitPrice;
    @Min(value = 0,message = "Stock miktarı en az 0 girilebilir.")
    private int unitsInStock;

    private boolean isActive;

   //TODO images eklenecek

    private String categoryName;

}
