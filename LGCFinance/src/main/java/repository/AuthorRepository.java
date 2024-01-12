/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import model.Author;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author sonho
 */
public class AuthorRepository{
    
    @PersistenceContext
    private EntityManager entityManager;

    public Author saveAuthor(Author author) {
        if(author.getId() == null) {
            entityManager.persist(author);
        } else {
            author = entityManager.merge(author);
        }
        return author;
    }

    public List<Author> getAllAuthors() {
       return entityManager.createQuery("SELECT * FROM author", Author.class).getResultList();
    }

    public Optional<Author> getById(Long id) {
        Author author = entityManager.find(Author.class, id);
        return Optional.ofNullable(author);
    }
    
}
