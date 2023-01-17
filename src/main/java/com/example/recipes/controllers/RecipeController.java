package com.example.recipes.controllers;

import com.example.recipes.model.Recipes;
import com.example.recipes.services.RecipeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) { //почему горит красным? НЕ понимаю
        this.recipeService = recipeService;
    }
@PostMapping("/recipe/add")
    public Recipes addRecipe(@RequestBody Recipes recipes) {
    return recipeService.addRecipe(recipes);
    }



    @GetMapping("/{id}")
    public Recipes getRecipes(@PathVariable Integer id) {
        return recipeService.getRecipe(id);
    }
}
