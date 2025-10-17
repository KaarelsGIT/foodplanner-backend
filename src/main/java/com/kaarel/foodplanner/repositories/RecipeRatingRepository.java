package com.kaarel.foodplanner.repositories;

import com.kaarel.foodplanner.models.RecipeRating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRatingRepository extends JpaRepository<RecipeRating, Long> {

    List<RecipeRating> findByRecipeId(Long recipeId);
}
