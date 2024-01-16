/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package observer;

import java.util.List;
import model.Author;

/**
 *
 * @author sonho
 */
public interface AuthorListObserver {
    public void updateAuthorList(List<Author> authors);
}
