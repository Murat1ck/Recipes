package com.example.recipes.controllers;

import com.example.recipes.model.Recipes;
import com.example.recipes.services.RecipeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) { //почему горит красным? НЕ понимаю
        this.recipeService = recipeService;
    }
@GetMapping("/recipe/add")
    public Recipes addRecipe(Recipes recipes) {
    return recipeService.addRecipe(recipes);
    }



    @GetMapping("/recipe/get")
    public Recipes getRecipes(Integer id) {
        return recipeService.getRecipe(id);
    }
}
