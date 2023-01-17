package com.example.recipes.services.impl;

import com.example.recipes.model.Ingredients;
import com.example.recipes.model.Recipes;
import com.example.recipes.services.IngredientsService;
import com.example.recipes.services.RecipeService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class RecipeServiceImpl implements RecipeService {
    private final Map<Integer, Recipes> recipesMap = new HashMap<>();
    private static Integer id = 1;

    @Override
    public Recipes addRecipe(Recipes recipes) {
        return recipesMap.put(id++,recipes);
    }

    @Override
    public Recipes getRecipe(Integer id) {
        return recipesMap.get(id);
    }

}