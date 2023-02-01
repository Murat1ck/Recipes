package com.example.recipes.services;

import com.example.recipes.model.Ingredients;
import com.example.recipes.model.Recipes;

import java.util.Collection;

public interface RecipeService {
    Recipes addRecipe(Recipes recipes);

    Recipes getRecipe(Integer id);
    Collection<Recipes> getAll();

    Recipes removeRecipes(int id);

    Recipes updateRecipes(int id, Recipes recipes);
}
