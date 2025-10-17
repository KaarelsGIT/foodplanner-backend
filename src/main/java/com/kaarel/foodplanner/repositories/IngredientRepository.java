package com.kaarel.foodplanner.repositories;

import com.kaarel.foodplanner.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
