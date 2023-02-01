package com.example.recipes.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Ingredients {
    @NotBlank(message = "Введите имя")
    private String name;
    @Positive
    private int quantityOfIngredients;
    private String measureUnit;
    private int id;
    public static int count = 1;
//        public Ingredients() {
//        this.name = "";
//        this.quantityOfIngredients = 0;
//        this.measureUnit = "";
//        this.id = count++;
//    }

//    public String getName() {
//        return name;
//    }
//
//    public int getQuantityOfIngredients() {
//        return quantityOfIngredients;
//    }
//
//    public void setQuantityOfIngredients(int quantityOfIngredients) {
//        this.quantityOfIngredients = quantityOfIngredients;
//    }
//
//    public String getMeasureUnit() {
//        return measureUnit;
//    }

}
