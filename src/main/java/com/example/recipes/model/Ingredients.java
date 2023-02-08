package com.example.recipes.model;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Ingredients {
    @NotBlank(message = "Введите имя")
    private String name;
    @Positive
    private int quantityOfIngredients;
    private String measureUnit;
    private int id;
    public static int count = 1;
    private Set<Ingredients> ingredients = new HashSet<>();

    public Ingredients(int id) {
        this.id = count++;
    }
}
