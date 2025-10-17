package com.kaarel.foodplanner.dtos;

import lombok.*;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IngredientDTO {

    private Long id;
    private String name;
    private String unit;
    private BigDecimal pricePerUnit;
    private Double quantity;
}
