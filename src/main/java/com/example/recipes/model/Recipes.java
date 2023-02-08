package com.example.recipes.model;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString

public class Recipes {
    @NotBlank(message = "Введите имя")
    private  String name;
    @Positive
    private int cookingTime;
    private int id;
    private int count = 1;
    private Set<Ingredients> ingredients = new HashSet<>();
    private List<String> cookingSteps = new ArrayList<>();

    public Recipes(int id) {
        this.id = count++;
    }
}
