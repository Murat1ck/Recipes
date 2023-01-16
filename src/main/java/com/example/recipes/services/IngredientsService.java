package com.example.recipes.services;

import com.example.recipes.model.Ingredients;

public interface IngredientsService {
    Ingredients addIngredients(Ingredients ingredients);

    Ingredients getByIdIngr(int id);
}

