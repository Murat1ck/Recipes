package com.example.recipes.services;

import com.example.recipes.model.Recipes;

public interface RecipeService {
    Recipes addRecipe(Recipes recipes);

    Recipes getRecipe(Integer id);
}
