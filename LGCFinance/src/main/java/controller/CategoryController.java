/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.interfaces.ControllerInterface;
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
    
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryView = new CategoryView();
        this.categoryRepository = categoryRepository;
        this.initSaveCategoryButton();
    }
    
    public void saveCategory() {
        var category = new Category();
        var randomId = Math.random() * 1000;
        var id = String.valueOf(randomId).replace(".", "");
        category.setId(Long.parseLong(id));
        category.setName(this.categoryView.getCategoryName());
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
