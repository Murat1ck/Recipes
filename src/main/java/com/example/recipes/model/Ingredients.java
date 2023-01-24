package com.example.recipes.model;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Ingredients {
    private final String name;
    private int quantityOfIngredients;
    private final String measureUnit;
    private final int id;
    public static int count = 1;

    public Ingredients() {
        this.name = "";
        this.quantityOfIngredients = 0;
        this.measureUnit = "";
        this.id = count++;
    }

    public String getName() {
        return name;
    }

    public int getQuantityOfIngredients() {
        return quantityOfIngredients;
    }

    public void setQuantityOfIngredients(int quantityOfIngredients) {
        this.quantityOfIngredients = quantityOfIngredients;
    }

    public String getMeasureUnit() {
        return measureUnit;
    }
}
