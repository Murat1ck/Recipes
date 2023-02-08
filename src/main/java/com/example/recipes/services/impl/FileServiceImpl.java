package com.example.recipes.services.impl;

import com.example.recipes.exception.FileException;
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
    public String readFromFileRecipes() throws FileException {
        try {
            return Files.readString(Path.of(dataFilePath, dataFileNameRecipes ));
        } catch (IOException e) {
            e.printStackTrace();
            throw new FileException("Ошибка чтения файла");
        }

    }
    @Override
    public String readFromFileIngredients() {
        try {
            Path path = Path.of(dataFilePath, dataFileNameIngredients);
            return Files.readString(path);
        } catch (IOException e) {
            e.printStackTrace();
            throw new FileException("Ошибка чтения файла");
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
    @Override
    public Path createTempFile(String suffix) {
        try {
            return Files.createTempFile(Path.of(dataFilePath), "tempFile", suffix);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

}
