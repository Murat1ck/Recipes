package com.example.recipes.controllers;

import com.example.recipes.model.Ingredients;
import com.example.recipes.model.Recipes;
import com.example.recipes.services.RecipeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;



@RestController
@RequestMapping("/recipe")
@Tag(name = "Рецепты", description = "CRUD-операции и другие эндпоинты для работы с рецептами")

public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

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
@PostMapping
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
        Recipes recipes = recipeService.getRecipe(id);
        if (recipes == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipes);
    }

    @GetMapping
    @Operation(summary = "Получение всех рецептов")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200",
                    description = "Список всех рецептов был найден",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Recipes.class))
                            )
                    })
    })
    public ResponseEntity<Object> getRecipeMap() {
        try {
            Path path = recipeService.getRecipeMap();
            if (Files.size(path) == 0) {
                return ResponseEntity.noContent().build();
            }
            InputStreamResource resource = new InputStreamResource(new FileInputStream(path.toFile()));
            return ResponseEntity.ok()
                    .contentType(MediaType.TEXT_PLAIN)
                    .contentLength(Files.size( path))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"Recipes.txt\"")
                    .body(resource);

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(e.toString());
        }

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
    public ResponseEntity<Recipes> updateRecipes(@PathVariable Integer id,@Valid @RequestBody Recipes newRecipes) {
    Recipes recipes = recipeService.updateRecipes(id, newRecipes);
    if (recipes == null) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(recipes);
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
        if (recipeService.removeRecipes(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
