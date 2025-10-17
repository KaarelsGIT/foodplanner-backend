package com.kaarel.foodplanner.dtos;

import com.kaarel.foodplanner.models.*;
import lombok.*;
import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDTO {

    private Long id;
    private String name;
    private String description;
    private RecipeCategory category;
    private String cuisine;
    private MainIngredient mainIngredient;
    private Set<IngredientDTO> ingredients;
    private List<RecipeRatingDTO> ratings;
    private String createdBy;
}
