package com.example.recipes.info;

import java.time.LocalDateTime;

public class Information {
    private String name = "Сергей";
    private String nameProject = "Рецепты";
    private String date = "11.01.2023";
    private String description = "Изготовления блюд";

    @Override
    public String toString() {
        return "Information{" +
                "name='" + name + '\'' +
                ", nameProject='" + nameProject + '\'' +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}



