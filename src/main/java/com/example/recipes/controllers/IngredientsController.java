package com.example.recipes.controllers;

import com.example.recipes.model.Ingredients;
import com.example.recipes.services.IngredientsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/ingredients")
@RequiredArgsConstructor
@Tag(name = "Ингредиенты", description = "CRUD-операции для работы с ингридиентами")
public class IngredientsController {
    private IngredientsService ingredientsService;

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
            )
    })
    public ResponseEntity<Ingredients> addIngredients(@Valid @RequestBody Ingredients ingredients) {
        return ResponseEntity.ok(ingredientsService.addIngredients(ingredients));
    }

    @GetMapping("/{id}")
    @Operation(
            description = "Поиск ингредиента по id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "Ингредиент найден", content = {
                    @Content(mediaType = "app/json", schema = @Schema(implementation = Ingredients.class))
            }
            )})
    @Parameters(value = {@Parameter(name = "id", example = "1")})
    ResponseEntity<Ingredients> getByIdIngr(@PathVariable int id) {
        return ResponseEntity.ok(ingredientsService.getByIdIngr(id));
    }

    @GetMapping
    @Operation(summary = "Получение всех ингредиентов")
    public Collection<Ingredients> getAll() {
        return this.ingredientsService.getAll();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Изенение ингредиентов по id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "Ингредиент изменён", content = {
                    @Content(mediaType = "app/json", schema = @Schema(implementation = Ingredients.class))
            }
            )})
    @Parameters(value = {@Parameter(name = "id", example = "1")})
    ResponseEntity<Ingredients> updateIngredients(@PathVariable Integer id, @Valid @RequestBody Ingredients ingredients) {
        return ResponseEntity.ok(ingredientsService.updateIngredients(id, ingredients));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление ингредиентов по id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "Ингредиент Удалён", content = {
                    @Content(mediaType = "app/json", schema = @Schema(implementation = Ingredients.class))
            }
            )})
    @Parameters(value = {@Parameter(name = "id", example = "1")})
    ResponseEntity<Ingredients> removeIngredients(@PathVariable Integer id) {
        return ResponseEntity.ok(ingredientsService.removeIngredients(id));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) ->{
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}


