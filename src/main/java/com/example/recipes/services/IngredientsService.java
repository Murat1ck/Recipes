package com.example.recipes.services;

import com.example.recipes.model.Ingredients;

import java.util.Collection;

public interface IngredientsService {
    Ingredients addIngredients(Ingredients ingredients);

    Ingredients getByIdIngr(int id);

    Collection <Ingredients> getAll();

    Ingredients removeIngredients(int id);

    Ingredients updateIngredients(int id, Ingredients ingredients);


}

