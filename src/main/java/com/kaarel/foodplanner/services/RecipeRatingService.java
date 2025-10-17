package com.kaarel.foodplanner.services;

import com.kaarel.foodplanner.models.RecipeRating;
import com.kaarel.foodplanner.repositories.RecipeRatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeRatingService {

    private final RecipeRatingRepository recipeRatingRepository;

    public RecipeRating addRating(RecipeRating rating) {
        return recipeRatingRepository.save(rating);
    }

    public List<RecipeRating> getRatingsForRecipe(Long recipeId) {
        return recipeRatingRepository.findByRecipeId(recipeId);
    }

    public double getAverageRatingForRecipe(Long recipeId) {
        List<RecipeRating> ratings = recipeRatingRepository.findByRecipeId(recipeId);
        return ratings.stream()
                .mapToDouble(RecipeRating::getRating)
                .average()
                .orElse(0.0);
    }
}
