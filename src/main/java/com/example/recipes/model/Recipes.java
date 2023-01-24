package com.example.recipes.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Recipes {
    private final String name;
    private final int cookingTime;
    private int id;
    private int count = 1;
    private Set<Ingredients> ingredients = new HashSet<>();
    private List<String> cookingSteps = new ArrayList<>();

    public Recipes(String name, int cookingTime, Set<Ingredients> ingredients, List<String> cookingSteps) {
        this.name = name;
        this.cookingTime = cookingTime;
        this.id = count++;
        this.ingredients = ingredients;
        this.cookingSteps = cookingSteps;
    }

    public String getName() {
        return name;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public Set<Ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getCookingSteps() {
        return cookingSteps;
    }

    public void setCookingSteps(List<String> cookingSteps) {
        this.cookingSteps = cookingSteps;
    }
}
