package com.example.recipes.services;

import javax.annotation.processing.FilerException;
import java.io.File;
import java.nio.file.Path;

public interface FileService {

    void saveToFileRecipes(String json);

    void cleanDataFileRecipes();

    String readFromFileRecipes() throws FilerException;

    void saveToFileIngredients(String json);

    void cleanDataFileIngredients();

    String readFromFileIngredients();

    File getIngredientDataFile();

    File getRecipeDataFile();


    Path createTempFile(String suffix);
}
