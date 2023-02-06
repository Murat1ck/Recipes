package com.example.recipes.services;

import com.example.recipes.model.Recipes;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;

public interface RecipeService {
    Recipes addRecipe(Recipes recipes);

    Recipes getRecipe(Integer id);
    Collection<Recipes> getAll();

    Recipes removeRecipes(int id);

    Recipes updateRecipes(int id, Recipes recipes);

    Path getRecipeMap() throws IOException;
}
