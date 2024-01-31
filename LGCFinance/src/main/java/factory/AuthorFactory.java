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

    public Author create(String name) {
        var author = new Author();
        author.setId(this.generateId());
        author.setName(name);
        return author;
    }
}
