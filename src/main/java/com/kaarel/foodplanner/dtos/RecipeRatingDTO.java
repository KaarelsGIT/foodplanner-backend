package com.kaarel.foodplanner.dtos;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecipeRatingDTO {

    private Long id;
    private int rating;
    private String comment;
    private String username;
}
