/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author sonho
 */
public class Expense implements Transaction{
    
    private Long id;
    
    private String name;
    
    private Double value;
    
    private LocalDate date;
    
    private String description;
    
    private String origin;
    
    private final String type = "EXPENSE";

    private Category category;
    
    private Author author;

    @Override
    public Long getId() {
        return id;
    }
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Double getValue() {
        return value;
    }
    
    @Override
    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public LocalDate getDate() {
        return date;
    }
    
    @Override
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getOrigin() {
        return origin;
    }

    @Override
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public Category getCategory() {
        return category;
    }

    @Override
    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public Author getAuthor() {
        return author;
    }

    @Override
    public void setAuthor(Author author) {
        this.author = author;
    }
}
