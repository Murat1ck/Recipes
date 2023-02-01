package com.example.recipes.services.impl;

import com.example.recipes.services.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class FileServiceImpl implements FileService {
    @Value("${path.to.files.folder}")
    private String dataFilePath;
    @Value("${name1.to.files.folder}")

    private String dataFileNameRecipes;
    @Value("${name.to.files.folder}")
    private String dataFileNameIngredients;


    @Override
    public boolean saveToFileRecipes(String json) {
        try {
            cleanDataFileRecipes();
            Files.writeString(Path.of(dataFilePath, dataFileNameRecipes), json);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }
    @Override
    public boolean saveToFileIngredients(String json) {
        try {
            cleanDataFileIngredients();
            Files.writeString(Path.of(dataFilePath, dataFileNameIngredients), json);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean cleanDataFileRecipes() {
        try {
            Path path = Path.of(dataFilePath, dataFileNameRecipes);
            Files.deleteIfExists(path);
            Files.createFile(path);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }
    @Override
    public boolean cleanDataFileIngredients() {
        try {
            Path path = Path.of(dataFilePath, dataFileNameIngredients);
            Files.deleteIfExists(path);
            Files.createFile(path);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public String readFromFileRecipes() {
        try {
            return Files.readString(Path.of(dataFilePath, dataFileNameIngredients));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
    @Override
    public String readFromFileIngredients() {
        try {
            return Files.readString(Path.of(dataFilePath, dataFileNameIngredients));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public File getIngredientDataFile() {
        return new File(dataFilePath + "/" + dataFileNameIngredients);
    }

    @Override
    public File getRecipeDataFile() {
        return new File(dataFilePath + "/" + dataFileNameRecipes);
    }

}
