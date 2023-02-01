package com.example.recipes.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter

public class Recipes {
    @NotBlank(message = "Введите имя")
    private  String name;
    @Positive
    private int cookingTime;
    private int id;
    private int count = 1;
    private Set<Ingredients> ingredients = new HashSet<>();
    private List<String> cookingSteps = new ArrayList<>();

//    public Recipes(String name, int cookingTime, Set<Ingredients> ingredients, List<String> cookingSteps) {
//        this.name = name;
//        this.cookingTime = cookingTime;
//        this.id = count++;
//        this.ingredients = ingredients;
//        this.cookingSteps = cookingSteps;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public int getCookingTime() {
//        return cookingTime;
//    }
//
//    public Set<Ingredients> getIngredients() {
//        return ingredients;
//    }
//
//    public void setIngredients(Set<Ingredients> ingredients) {
//        this.ingredients = ingredients;
//    }
//
//    public List<String> getCookingSteps() {
//        return cookingSteps;
//    }
//
//    public void setCookingSteps(List<String> cookingSteps) {
//        this.cookingSteps = cookingSteps;
//    }
}
