package com.example.recipes.services.impl;

import com.example.recipes.model.Recipes;
import com.example.recipes.services.FileService;
import com.example.recipes.services.RecipeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.processing.FilerException;

import java.io.IOException;

import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Collection;
import java.util.TreeMap;


@Service
public class RecipeServiceImpl implements RecipeService {
    private TreeMap<Integer, Recipes> recipesMap = new TreeMap<>();
    private Integer id = 1;
    final private FileService filesService;

    public RecipeServiceImpl(FileService filesService) {
        this.filesService = filesService;
    }
    @PostConstruct
    private void init() {
        try {
            readFromFileRecipe();
        } catch (Exception e) {
            e.printStackTrace();
        }    }
    public void saveToFileRecipe() {
        try {
            String json = new ObjectMapper().writeValueAsString(recipesMap);
            filesService.saveToFileRecipes(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    public void readFromFileRecipe() {

        try {
            String json = filesService.readFromFileRecipes();
            recipesMap = new ObjectMapper().readValue(json, new TypeReference<>() {
            });
        } catch (JsonProcessingException | FilerException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Recipes addRecipe(Recipes recipes) {
        recipesMap.put(id++,recipes);
        saveToFileRecipe();
        return recipes;
    }

    @Override
    public Recipes getRecipe(Integer id) {
        return recipesMap.get(id);
    }

    @Override
    public Collection<Recipes> getAll() {
        return recipesMap.values();
    }

    @Override
    public boolean removeRecipes(int id) {
        if (recipesMap.containsKey(id)) {
            recipesMap.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public Recipes updateRecipes(int id, Recipes newRecipes) {
        if (recipesMap.containsKey(id)) {
            recipesMap.put(id, newRecipes);
            saveToFileRecipe();
            return newRecipes;
        }
        return null;
    }

    @Override
    public Path getRecipeMap() throws IOException {
        Path path = filesService.createTempFile("Recipes");
        for (Recipes recipe : recipesMap.values()) {
            try (Writer writer = Files.newBufferedWriter( path, StandardOpenOption.APPEND)) {
                writer.append(recipe.getName()).append(". ");
                writer.append("\n");
                writer.append("Время приготовления: ").append(String.valueOf(recipe.getCookingTime())).append(" минут. ");
                writer.append("\n");
                writer.append("Ингридиенты:" + "\n").append(String.valueOf(recipe.getIngredients()));
                writer.append("\n");
                writer.append("Шаги приготовления:" + "\n").append(String.valueOf(recipe.getCookingSteps()));
            }
        }
        return path;
    }

}
