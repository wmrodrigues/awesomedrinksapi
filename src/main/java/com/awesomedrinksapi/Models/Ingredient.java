package com.awesomedrinksapi.Models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "ingredientCategoryId")
    private IngredientCategory ingredientCategory;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IngredientCategory getIngredientCategory() { return this.ingredientCategory; }

    public void setIngredientCategory(IngredientCategory ingredientCategory) { this.ingredientCategory = ingredientCategory; }
}
