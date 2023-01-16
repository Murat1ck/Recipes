package com.example.recipes.services.impl;

import com.example.recipes.model.Ingredients;
import com.example.recipes.services.IngredientsService;

import java.util.HashMap;
import java.util.Map;

public class IngredientsServiceImpl implements IngredientsService {
    private Map<Integer, Ingredients> ingredientsMap = new HashMap<>();
    private int id = 1;
    @Override
    public Ingredients addIngredients(Ingredients ingredients) {
        return ingredientsMap.put(id++, ingredients);
    }

    @Override
    public Ingredients getByIdIngr(int id) {
        return ingredientsMap.get(id);
    }
}
