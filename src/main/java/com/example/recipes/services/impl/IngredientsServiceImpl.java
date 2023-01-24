package com.example.recipes.services.impl;

import com.example.recipes.model.Ingredients;
import com.example.recipes.services.IngredientsService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class IngredientsServiceImpl implements IngredientsService {
    private final Map<Integer, Ingredients> ingredientsMap = new HashMap<>();
    private static int id = 1;
    @Override
    public Ingredients addIngredients(Ingredients ingredients) {
        return ingredientsMap.put(id++, ingredients);
    }

    @Override
    public Ingredients getByIdIngr(int id) {
        return ingredientsMap.get(id);
    }
}
