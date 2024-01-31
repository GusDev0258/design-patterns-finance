/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

import model.Author;

/**
 *
 * @author sonho
 */
public class AuthorFactory implements ModelFactory {

    public Author create(String name, Double balance) {
        var author = new Author();
        author.setId(this.generateId());
        author.setBalance(balance);
        author.setName(name);
        return author;
    }
}
