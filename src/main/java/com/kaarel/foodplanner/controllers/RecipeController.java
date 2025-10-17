package com.kaarel.foodplanner.controllers;

import com.kaarel.foodplanner.models.*;
import com.kaarel.foodplanner.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/recipes")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @GetMapping("/{id}")
    public Recipe getRecipeById(@PathVariable Long id) {
        return recipeService.getRecipeById(id);
    }

    @PostMapping
    public Recipe createRecipe(@RequestBody Recipe recipe, Authentication auth) {
        String username = auth.getName();
        return recipeService.createRecipe(recipe, username);
    }

    @PutMapping("/{id}")
    public Recipe updateRecipe(@PathVariable Long id, @RequestBody Recipe recipe) {
        return recipeService.updateRecipe(id, recipe);
    }

    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipe(id);
    }

    @GetMapping("/category/{category}")
    public List<Recipe> getByCategory(@PathVariable RecipeCategory category) {
        return recipeService.findByCategory(category);
    }

    @GetMapping("/ingredient/{mainIngredient}")
    public List<Recipe> getByMainIngredient(@PathVariable MainIngredient mainIngredient) {
        return recipeService.findByMainIngredient(mainIngredient);
    }

    @GetMapping("/cuisine/{cuisine}")
    public List<Recipe> getByCuisine(@PathVariable String cuisine) {
        return recipeService.findByCuisine(cuisine);
    }
}
