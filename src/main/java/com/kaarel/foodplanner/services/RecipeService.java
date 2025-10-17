package com.kaarel.foodplanner.services;

import com.kaarel.foodplanner.models.*;
import com.kaarel.foodplanner.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final UserService userService;

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Recipe getRecipeById(Long id) {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recipe not found"));
    }

    public Recipe createRecipe(Recipe recipe, String username) {
        User user = userService.getUserByUsername(username);
        recipe.setCreatedBy(user);
        return recipeRepository.save(recipe);
    }

    public Recipe updateRecipe(Long id, Recipe updatedRecipe) {
        Recipe existing = getRecipeById(id);
        existing.setName(updatedRecipe.getName());
        existing.setDescription(updatedRecipe.getDescription());
        existing.setCategory(updatedRecipe.getCategory());
        existing.setCuisine(updatedRecipe.getCuisine());
        existing.setMainIngredient(updatedRecipe.getMainIngredient());
        existing.setIngredients(updatedRecipe.getIngredients());
        return recipeRepository.save(existing);
    }

    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }

    public List<Recipe> findByCategory(RecipeCategory category) {
        return recipeRepository.findAllByCategory(category);
    }

    public List<Recipe> findByMainIngredient(MainIngredient ingredient) {
        return recipeRepository.findAllByMainIngredient(ingredient);
    }

    public List<Recipe> findByCuisine(String cuisine) {
        return recipeRepository.findAllByCuisineIgnoreCase(cuisine);
    }
}
