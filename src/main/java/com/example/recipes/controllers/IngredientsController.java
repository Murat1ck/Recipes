package com.example.recipes.controllers;

import com.example.recipes.model.Ingredients;
import com.example.recipes.services.IngredientsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingredients")
public class IngredientsController{
    private IngredientsService ingredientsService;

    public IngredientsController(IngredientsService ingredientsService) {
        this.ingredientsService = ingredientsService;
    }
    @PostMapping
    public Ingredients addIngredients(@RequestBody Ingredients ingredients) {
    return ingredientsService.addIngredients(ingredients);
    }

@GetMapping("/{id}")
    public Ingredients getByIdIngr(@PathVariable int id) {
        return ingredientsService.getByIdIngr(id);
    }
}


