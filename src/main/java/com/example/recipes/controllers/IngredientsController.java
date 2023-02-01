package com.example.recipes.controllers;

import com.example.recipes.model.Ingredients;
import com.example.recipes.services.IngredientsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/ingredients")
public class IngredientsController{
    private IngredientsService ingredientsService;

    public IngredientsController(IngredientsService ingredientsService) {
        this.ingredientsService = ingredientsService;
    }
    @PostMapping
    public ResponseEntity<Ingredients> addIngredients(@RequestBody Ingredients ingredients) {
    return ResponseEntity.ok(ingredientsService.addIngredients(ingredients));
    }

@GetMapping("/{id}")
    public ResponseEntity <Ingredients> getByIdIngr(@PathVariable int id) {
        return ResponseEntity.ok(ingredientsService.getByIdIngr(id));
    }
@GetMapping
    public Collection<Ingredients> getAll() {
        return this.ingredientsService.getAll();
    }
@PutMapping("/{id}")
    public ResponseEntity<Ingredients> updateIngredients(@PathVariable Integer id, @RequestBody Ingredients ingredients) {
    return ResponseEntity.ok(ingredientsService.updateIngredients(id, ingredients));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Ingredients> removeIngredients(@PathVariable Integer id) {
        return ResponseEntity.ok(ingredientsService.removeIngredients(id));
    }



}


