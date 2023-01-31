package com.example.recipes.services;

public interface FilesService {

    boolean saveToFileRecipes(String json);

    boolean cleanDataFileRecipes();

    String readFromFileRecipes();

    boolean saveToFileIngredients(String json);

    boolean cleanDataFileIngredients();

    String readFromFileIngredients();
}
