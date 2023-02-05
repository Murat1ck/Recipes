package com.example.recipes.controllers;

import com.example.recipes.services.FileService;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
@RequestMapping("/files")
public class FilesController {

        private final FileService filesService;

        public FilesController(FileService filesService) {
                this.filesService = filesService;
        }
        @GetMapping(value = "/export/recipe")
        public ResponseEntity<InputStreamResource> downloadRecipeDataFile() throws FileNotFoundException {
                File recipeDataFile = filesService.getRecipeDataFile();
                if (recipeDataFile.exists()) {
                        InputStreamResource resource = new InputStreamResource(new FileInputStream(recipeDataFile));
                        return ResponseEntity.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .contentLength(recipeDataFile.length())
                                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"RecipesLog.json\"")
                                .body(resource);
                } else {
                        return ResponseEntity.noContent().build();
                }
        }
        @GetMapping(value = "/export/ingredient")
        public ResponseEntity<InputStreamResource> downloadIngredientDataFile() throws FileNotFoundException {
                File ingredientDataFile = filesService.getIngredientDataFile();
                if (ingredientDataFile.exists()) {
                        InputStreamResource resource = new InputStreamResource(new FileInputStream(ingredientDataFile));
                        return ResponseEntity.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .contentLength(ingredientDataFile.length())
                                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"IngredientsLog.json\"")
                                .body(resource);
                } else {
                        return ResponseEntity.noContent().build();
                }
        }
        @PostMapping(value = "/import/ingredient", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
        public ResponseEntity<Void> uploadIngredientDataFail(@RequestParam MultipartFile file) {
                filesService.cleanDataFileIngredients();
                File ingredientDataFile = filesService.getIngredientDataFile();

                try (FileOutputStream fos = new FileOutputStream(ingredientDataFile)) {
                        IOUtils.copy(file.getInputStream(), fos);
                        return ResponseEntity.ok().build();
                } catch (IOException e) {
                        e.printStackTrace();
                }
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();


        }
        @PostMapping(value = "/import/recipe", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
        public ResponseEntity<Void> uploadRecipeDataFail(@RequestParam MultipartFile file1) {
                filesService.cleanDataFileRecipes();
                File recipeDataFile = filesService.getRecipeDataFile();

                try (FileOutputStream fos = new FileOutputStream(recipeDataFile)) {
                        IOUtils.copy(file1.getInputStream(), fos);
                        return ResponseEntity.ok().build();
                } catch (IOException e) {
                        e.printStackTrace();
                }
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }

}
