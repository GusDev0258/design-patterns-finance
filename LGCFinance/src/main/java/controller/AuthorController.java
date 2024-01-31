/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.interfaces.ControllerInterface;
import factory.AuthorFactory;
import repository.AuthorRepository;
import view.AuthorView;
import model.Author;

/**
 *
 * @author sonho
 */
public class AuthorController implements ControllerInterface{
    AuthorView authorView;
    
    AuthorRepository authorRepository;
    AuthorFactory authorFactory;
    public AuthorController(AuthorRepository authorRepository) {
        this.authorView = new AuthorView();
        this.authorRepository = authorRepository;
        this.initSaveAuthorButton();
        this.authorFactory = new AuthorFactory();
    }
    
    public void saveAuthor() {
        var authorBalance = Double.parseDouble(this.authorView.getAuthorBalance());
        var authorName = this.authorView.getAuthorName();
        Author author = authorFactory.create(authorName, authorBalance);
        authorRepository.saveAuthor(author);
    }
    
    public void initSaveAuthorButton() {
        this.authorView.addBtnAction(this.authorView.getBtnAddAuthor(), e -> saveAuthor());
    }

    @Override
    public void openView() {
        this.authorView.showView();
    }
}
