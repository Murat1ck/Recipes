package com.example.recipes.controllers;

import com.example.recipes.model.Ingredients;
import com.example.recipes.services.IngredientsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ingredients")
public class IngredientsController{
    private IngredientsService ingredientsService;

    public IngredientsController(IngredientsService ingredientsService) { //почему горит красным? НЕ понимаю
        this.ingredientsService = ingredientsService;
    }
@GetMapping("/ingredients/add")
    public Ingredients addIngredients(Ingredients ingredients) {
    return ingredientsService.addIngredients(ingredients);
    }

@GetMapping("/ingredients/getId")
    public Ingredients getByIdIngr(int id) {
        return ingredientsService.getByIdIngr(id);
    }
}


