package com.example.recipes.services.impl;

import com.example.recipes.model.Recipes;
import com.example.recipes.services.FilesService;
import com.example.recipes.services.RecipeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Service
public class RecipeServiceImpl implements RecipeService {
    private TreeMap<Integer, Recipes> recipesMap = new TreeMap<>();
    private static Integer id = 1;
    final private FilesService filesService;

    public RecipeServiceImpl(FilesService filesService) {
        this.filesService = filesService;
    }
    @PostConstruct
    private void init() {
        readFromFileRecipe();
    }
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
            recipesMap = new ObjectMapper().readValue(json, new TypeReference<TreeMap<Integer, Recipes>>() {
            });
        } catch (JsonProcessingException e) {
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
    public Recipes removeRecipes(int id) {
        return recipesMap.remove(id);
    }

    @Override
    public Recipes updateRecipes(int id, Recipes recipes) {
        recipesMap.put(id, recipes);
        saveToFileRecipe();
        return recipes;
    }


}
