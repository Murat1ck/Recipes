package com.example.recipes.services.impl;

import com.example.recipes.model.Ingredients;
import com.example.recipes.services.FilesService;
import com.example.recipes.services.IngredientsService;
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
public class IngredientsServiceImpl implements IngredientsService {
    private TreeMap<Integer, Ingredients> ingredientsMap = new TreeMap<>();
    private static int id = 1;
    final private FilesService filesService;

    public IngredientsServiceImpl(FilesService filesService) {
        this.filesService = filesService;
    }
    @PostConstruct
    private void init() {
        readFromFile();
    }


    @Override
    public Ingredients addIngredients(Ingredients ingredients) {
        ingredientsMap.put(id++, ingredients);
        readFromFile();
        return ingredients;

    }

    @Override
    public Ingredients getByIdIngr(int id) {
        return ingredientsMap.get(id);
    }

    @Override
    public Collection<Ingredients> getAll() {
        return ingredientsMap.values();
    }

    public Ingredients removeIngredients(int id) {
        return ingredientsMap.remove(id);
    }

    public Ingredients updateIngredients(int id, Ingredients ingredients) {
        ingredientsMap.put(id, ingredients);
        saveToFile();
        return ingredients;
    }
    public void saveToFile() {
        try {
            String json = new ObjectMapper().writeValueAsString(ingredientsMap);
            filesService.saveToFileIngredients(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    public void readFromFile() {

        try {
            String json = filesService.readFromFileIngredients();
            ingredientsMap = new ObjectMapper().readValue(json, new TypeReference<TreeMap<Integer, Ingredients>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


}
