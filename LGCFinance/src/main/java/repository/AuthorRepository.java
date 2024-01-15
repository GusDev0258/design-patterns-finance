/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import model.Author;
import observer.AuthorListObserver;

/**
 *
 * @author sonho
 */
public class AuthorRepository {
    
    private static final AuthorRepository instance = new AuthorRepository();
    private List<AuthorListObserver> observers = new ArrayList<>();
    
    
    private List<Author> authors = new ArrayList<>();
    
    private AuthorRepository(){};
    
    public static AuthorRepository getInstance() {
        return instance;
    }
    
    public List<Author> getAll() {
        return this.authors;
    }
    
    
    public void saveAuthor(Author author) {
        var authorFound = this.findById(author.getId());
        if(authorFound == null) {
            authors.add(author);
            System.out.println("Author salvo com sucesso!");
            this.notifyObservers(authors);
        } else {
            authors.remove(author);
            authorFound.setBalance(author.getBalance());
            authorFound.setName(author.getName());
            authors.add(author);
            System.out.println("Author atualizado!");
            this.notifyObservers(authors);
        }
    }
    
    public void deleteById(Long id) {
        var authorFound = this.findById(id);
        if(authorFound != null) {
            authors.remove(authorFound);
            this.notifyObservers(authors);
        } else {
            System.out.println("Autor não encontrado");
        }
    }
    
    public Author findById(Long id) {
        for(Author author: authors) {
            if (Objects.equals(author.getId(), id)){
                return author;
            }
        }
        return null;
    }
    
    public void addObserver(AuthorListObserver observer) { 
        this.observers.add(observer);
    }
    
    public void removeObserver(AuthorListObserver observer) {
        this.observers.add(observer);
    }
    
    public void notifyObservers(List<Author> authors) {
        for(AuthorListObserver authorObserver : observers) {
            System.out.println("notified");
            authorObserver.update(authors);
        }
    }
    
}