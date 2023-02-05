package com.example.recipes.services;

import javax.annotation.processing.FilerException;
import java.io.File;

public interface FileService {

    boolean saveToFileRecipes(String json);

    boolean cleanDataFileRecipes();

    String readFromFileRecipes() throws FilerException;

    boolean saveToFileIngredients(String json);

    boolean cleanDataFileIngredients();

    String readFromFileIngredients();

    File getIngredientDataFile();

    File getRecipeDataFile();


}
