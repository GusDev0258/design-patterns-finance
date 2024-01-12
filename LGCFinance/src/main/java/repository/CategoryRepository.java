/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
import model.Category;

/**
 *
 * @author sonho
 */
public class CategoryRepository {
    
    @PersistenceContext
    private EntityManager entityManager;

    public Category saveAuthor(Category category) {
        if(category.getId() == null) {
            entityManager.persist(category);
        } else {
            category = entityManager.merge(category);
        }
        return category;
    }

    public List<Category> getAllCategories() {
       return entityManager.createQuery("SELECT * FROM category", Category.class).getResultList();
    }

    public Optional<Category> getById(Long id) {
        Category category = entityManager.find(Category.class, id);
        return Optional.ofNullable(category);
    }
}
