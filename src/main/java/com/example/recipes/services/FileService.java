package com.example.recipes.services;

import java.io.File;

public interface FileService {

    boolean saveToFileRecipes(String json);

    boolean cleanDataFileRecipes();

    String readFromFileRecipes();

    boolean saveToFileIngredients(String json);

    boolean cleanDataFileIngredients();

    String readFromFileIngredients();

    File getIngredientDataFile();

    File getRecipeDataFile();


}
