/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.interfaces.ControllerInterface;
import factory.CategoryFactory;
import repository.CategoryRepository;
import view.CategoryView;
import model.Category;

/**
 *
 * @author sonho
 */
public class CategoryController implements ControllerInterface{
    CategoryView categoryView;
    
    CategoryRepository categoryRepository;
    CategoryFactory categoryFactory;
    
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryView = new CategoryView();
        this.categoryRepository = categoryRepository;
        this.initSaveCategoryButton();
        this.categoryFactory = new CategoryFactory();
    }
    
    public void saveCategory() {
        Category category = categoryFactory.create(this.categoryView.getCategoryName());
        categoryRepository.saveCategory(category);
    }
    
    public void initSaveCategoryButton() {
        this.categoryView.addBtnAction(this.categoryView.getBtnAddCategory(), e -> saveCategory());
    }
    
    @Override
    public void openView() {
        this.categoryView.showView();
    }
    
}
