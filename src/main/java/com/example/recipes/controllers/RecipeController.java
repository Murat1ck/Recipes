package com.example.recipes.controllers;

import com.example.recipes.model.Recipes;
import com.example.recipes.services.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
@PostMapping
    public ResponseEntity <Recipes> addRecipe(@RequestBody Recipes recipes) {
    return ResponseEntity.ok(recipeService.addRecipe(recipes));
    }



    @GetMapping("/{id}")
    public ResponseEntity <Recipes> getRecipes(@PathVariable Integer id) {
        return ResponseEntity.ok(recipeService.getRecipe(id));
    }

    @GetMapping
    public ResponseEntity<Collection<Recipes>> getAllRecipes() {
        return ResponseEntity.ok(recipeService.getAll());
    }
@PutMapping("/{id}")
    public ResponseEntity<Recipes> updateRecipes(@PathVariable Integer id, @RequestBody Recipes recipes) {
        return ResponseEntity.ok(recipeService.updateRecipes(id, recipes));
    }
@DeleteMapping("/{id}")
    public ResponseEntity<Recipes> removeRecipes(@PathVariable Integer id) {
        return ResponseEntity.ok(recipeService.removeRecipes(id));
    }

}
