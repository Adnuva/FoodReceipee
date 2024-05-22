package com.example.foodreceipe.model;

import java.util.List;

public class Recipe {
    private String name;
    private String imageUrl;
    private List<String> steps;

    public Recipe(String name, String imageUrl, List<String> steps) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.steps = steps;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    // Metode untuk mendapatkan langkah-langkah resep
    public List<String> getSteps() {
        return steps;
    }

    // Metode untuk mengatur langkah-langkah resep
    public void setSteps(List<String> steps) {
        this.steps = steps;
    }
}
