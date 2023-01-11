package com.example.recipes.controllers;

import com.example.recipes.info.Information;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
    @GetMapping
    public String appStarting() {
        return "Приложение запущено";
    }
    @GetMapping("/info")
    public String info() {
        return new Information().toString();
    }


}
