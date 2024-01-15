/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.interfaces.ControllerInterface;
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
    
    public AuthorController(AuthorRepository authorRepository) {
        this.authorView = new AuthorView();
        this.authorRepository = authorRepository;
        this.initSaveAuthorButton();
    }
    
    public void saveAuthor() {
        var author = new Author();
        var randomId = Math.random() * 1000;
        var id = String.valueOf(randomId).replace(".", "");
        author.setId(Long.parseLong(id));
        author.setBalance(Double.parseDouble(this.authorView.getAuthorBalance()));
        author.setName(this.authorView.getAuthorName());
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
