package com.kaarel.foodplanner.repositories;

import com.kaarel.foodplanner.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findAllByCategory(RecipeCategory category);

    List<Recipe> findAllByMainIngredient(MainIngredient mainIngredient);

    List<Recipe> findAllByCuisineIgnoreCase(String cuisine);
}
