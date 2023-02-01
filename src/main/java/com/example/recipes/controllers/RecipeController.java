package com.example.recipes.controllers;

import com.example.recipes.model.Ingredients;
import com.example.recipes.model.Recipes;
import com.example.recipes.services.RecipeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
@PostMapping
@Operation(summary = "Добавление ингредиента")
@ApiResponses(value = {
        @ApiResponse(
                responseCode = "200",
                description = "Ингредиент добавлен",
                content = {
                        @Content(
                                mediaType = "app/json",
                                schema = @Schema(implementation = Ingredients.class)
                        )
                }
        )}
)
    public ResponseEntity <Recipes> addRecipe(@Valid @RequestBody Recipes recipes) {
    return ResponseEntity.ok(recipeService.addRecipe(recipes));
    }



    @GetMapping("/{id}")
    @Operation(
            description = "Поиск рецептов по id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "Рецепт найден", content = {
                    @Content(mediaType = "app/json", schema = @Schema(implementation = Recipes.class))
            }
            )})
    @Parameters(value = {@Parameter(name = "id", example = "1")})
    public ResponseEntity <Recipes> getRecipes(@PathVariable Integer id) {
        return ResponseEntity.ok(recipeService.getRecipe(id));
    }

    @GetMapping
    @Operation(summary = "Получение всех рецептов")
    public ResponseEntity<Collection<Recipes>> getAllRecipes() {
        return ResponseEntity.ok(recipeService.getAll());
    }
@PutMapping("/{id}")
@Operation(summary = "Изенение рецептов по id")
@ApiResponses  (value = {
        @ApiResponse(
                responseCode = "200", description = "Рецепт изменён", content = {
                @Content(mediaType = "app/json", schema = @Schema(implementation = Recipes.class))
        }
        )})
@Parameters(value = {@Parameter(name = "id", example = "1")})
    public ResponseEntity<Recipes> updateRecipes(@PathVariable Integer id,@Valid @RequestBody Recipes recipes) {
        return ResponseEntity.ok(recipeService.updateRecipes(id, recipes));
    }
@DeleteMapping("/{id}")
@Operation(summary = "Удаление рецептов по id")
@ApiResponses  (value = {
        @ApiResponse(
                responseCode = "200", description = "Рецепт Удалён", content = {
                @Content(mediaType = "app/json", schema = @Schema(implementation = Recipes.class))
        }
        )})
@Parameters(value = {@Parameter(name = "id", example = "1")})

    public ResponseEntity<Recipes> removeRecipes(@PathVariable Integer id) {
        return ResponseEntity.ok(recipeService.removeRecipes(id));
    }

}
