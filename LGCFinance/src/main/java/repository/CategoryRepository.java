/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import model.Category;

/**
 *
 * @author sonho
 */
public class CategoryRepository {
    
    private static final CategoryRepository instance = new CategoryRepository();
    
    private List<Category> categories = new ArrayList<>();
    
    private CategoryRepository(){};
    
    public static CategoryRepository getInstance() {
        return instance;
    }
    
    public List<Category> findAll() {
        return this.categories;
    }

    
    public void saveCategory(Category category) {
        var categoryFound = this.findById(category.getId());
        if(categoryFound == null) {
            categories.add(category);
            System.out.println("Categoria salva com sucesso!");
        } else {
            categories.remove(category);
            categoryFound.setName(category.getName());
            categories.add(category);
            System.out.println("Categoria atualizada!");
        }
    }
    
    public void deleteById(Long id) {
        var categoryFound = this.findById(id);
        if(categoryFound != null) {
            categories.remove(categoryFound);
        } else {
            System.out.println("Categoria não encontrada");
        }
    }
    
    public Category findById(Long id) {
        for(Category category: categories) {
            if (Objects.equals(category.getId(), id)){
                return category;
            }
        }
        return null;
    }
    
}
